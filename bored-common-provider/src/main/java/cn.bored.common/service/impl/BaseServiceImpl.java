package cn.bored.common.service.impl;

import cn.bored.common.service.BaseService;
import cn.bored.common.web.AbstractBaseController;
import cn.bored.domain.BaseEntity;
import mapper.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description
 * @author: hanghang
 * @create: 2019-06-27 16:48
 **/

public class BaseServiceImpl<T extends  BaseEntity,D extends MyMapper> implements BaseService<T> {

    @Autowired
    protected AbstractBaseController abstractBaseController;

   @Autowired
    protected  D dao;

    @Override
    public int add(T entity) {
        return dao.insert(entity);
    }

    @Override
    public int delByID(T entity) {
        //根据主键删除
        return dao.deleteByPrimaryKey(entity);
    }

    @Override
    public int delByObject(T entity) {
        return dao.delete(entity);
    }

    @Override
    public int updateByPrimaryKeySelective(T entity) {
        //根据id 并修改字段值不等于null，可以等于""
        //updateByPrimaryKeySelective的原理，是根据entity对象的属性值，是否为null，如果为null，则最终生成的update语句里，将忽略该列，否则会更新该列。
        return dao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List selectByObject(T baseEntity) {
        return dao.select(baseEntity);
    }

}
