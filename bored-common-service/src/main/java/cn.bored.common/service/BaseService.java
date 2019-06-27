package cn.bored.common.service;

import cn.bored.domain.BaseEntity;

import java.util.List;

/**
 * @description
 * @author: hanghang
 * @create: 2019-06-27 16:38
 **/
public interface BaseService<T extends BaseEntity> {

    int add(T entity);
    int delByID(T entity);
    int delByObject(T entity);
    int updateByPrimaryKeySelective(T entity);
    List<T> selectByObject(T t);

}
