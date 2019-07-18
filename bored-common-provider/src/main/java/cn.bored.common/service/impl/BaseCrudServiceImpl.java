package cn.bored.common.service.impl;

import cn.bored.common.dto.AbstractBaseDomain;
import cn.bored.common.service.BaseCrudService;
import mapper.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
@Component
public class BaseCrudServiceImpl<T extends AbstractBaseDomain, M extends MyMapper<T>> implements BaseCrudService<T> {

    @Autowired
    protected M mapper;

    private Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @Override
    public boolean unique(String property, String value) {
        Example example = new Example(entityClass);
        example.createCriteria().andEqualTo(property, value);
        int result = mapper.selectCountByExample(example);
        if (result > 0) {
            return false;
        }
        return true;
    }

    @Override
    public T save(T domain) {
        int result = 0;
        Date currentDate = new Date();
        // 创建
        if (domain.getId() == null) {
            String randomStr="";
            for (int i = 0; i < 9; i++) {
                int random=(int)(Math.random()*9);
                if(randomStr.indexOf(random+"")!=-1){
                    i=i-1;
                }else{
                    randomStr+=random;
                }
            }
            long b = Integer.parseInt(randomStr);
            domain.setId(b);
            /**
             * 用于自动回显 ID，领域模型中需要 @ID 注解的支持
             * {@link AbstractBaseDomain}
             */
            result = mapper.insert(domain);
        }

        // 更新
        else {

            result = mapper.updateByPrimaryKeySelective(domain);
        }

        // 保存数据成功
        if (result > 0) {
            return domain;
        }

        // 保存数据失败
        return null;
    }
}
