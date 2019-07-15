package play.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class controller {
   // @GetMapping(value = {"/index",""})
   @RequestMapping(value = {"/index",""}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = {"/user"}, method = RequestMethod.GET)
    public String user(){
        return "user";
    }
    @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
    public String users(){
        return "users";
    }
    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value = {"/pal"}, method = RequestMethod.GET)
    public String pal(){
        return "pal";
    }
    @RequestMapping(value = {"/yunxin"}, method = RequestMethod.GET)
    public String yunxin(){
        return "yunxin";
    }
}
