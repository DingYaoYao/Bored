package cn.bored.common.utils;

/**
 * @description
 * @author: hanghang
 * @create: 2019-06-30 23:47
 **/
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class RequestImService {

    public static void main(String[] args) {
//        ImServiceDTO xuang = createACCID("xuang");
//        System.out.println(xuang);

//        ImServiceDTO fa6f0 = refreshToken("fa6f0");
//        System.out.println(fa6f0);

//        ImServiceDTO fa6f0 = block("fa6f0");
//        System.out.println(fa6f0);
        ImServiceDTO fa6f0 = unBlock("fa6f0");
        System.out.println(fa6f0);
    }

    //text file path
    private static final String  filePath="C:\\Users\\35584\\Desktop\\";
    private static final String create=filePath+"create.txt";
    private static final String refresh=filePath+"refresh.txt";
    private static final String block=filePath+"block.txt";
    private static final String unblock=filePath+"unblock.txt";


    //禁用accid
    public static ImServiceDTO block(String accid){
        String url="https://api.netease.im/nimserver/user/block.action";
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid",accid));
      return  check(url,nvps,block);
    }
    //解禁accid
    public static ImServiceDTO unBlock(String accid){
        String url="https://api.netease.im/nimserver/user/unblock.action";
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid",accid));
        return  check(url,nvps,unblock);
    }
    //更新accid更新token
    public static ImServiceDTO refreshToken(String accid){
        String   url = "https://api.netease.im/nimserver/user/refreshToken.action";
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid",accid));
        return check(url,nvps,refresh);
    }
    //创建accid
    public static ImServiceDTO createACCID(String userName){
        String   url = "https://api.netease.im/nimserver/user/create.action";
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid", UUID.randomUUID().toString().substring(0,5)));
        nvps.add(new BasicNameValuePair("name", userName));
        return check(url, nvps,create);
    }
    //获得请求结果
    private static ImServiceDTO check(String url,List<NameValuePair> nvps,String filePath){
        try {
            ImServiceDTO imServiceDTO=null;
            String request=null;
            for (int i = 0; i < 3; i++) {
                // 设置请求的参数
                request= request(url,nvps);
                imServiceDTO= JsonUtils.jsonToPojo(request, ImServiceDTO.class);
                if (imServiceDTO.getCode()==200) {
                    System.out.println("-------------------用户操作accid成功");
                    break;
                }
            }
            writeFile(filePath,nvps.get(0).getValue(),request);
            return imServiceDTO;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //向imService 服务器发送请求
    private  static String request(String url,List<NameValuePair> nvps ) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        String appKey = "53d4384297427bff1eb901be42f2e18a";
        String appSecret = "888443b1c07f";
        String nonce = UUID.randomUUID().toString();  //小于128
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码

        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        CloseableHttpResponse response = httpClient.execute(httpPost);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        response.close();
        // 打印执行结果EntityUtils.toString(response.getEntity(), "utf-8")
        System.out.println("Request Method  result====>"+result);
       return result;
    }
    //将对accid的操作结果写入文件中
    public static void writeFile(String filePath,String...value){
        try {
            File file=new File(filePath);
            if(!file.exists()){
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(
                    file,true));
            for (int i = 0; i < value.length; i++) {
                osw.write(value[i]+"\n");
            }
            osw.write(new SimpleDateFormat().format(new Date())+"------\n\n");
            osw.flush();
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("写入文件异常-------这不是重点-----可以不用理会--");
        }
    }
}
