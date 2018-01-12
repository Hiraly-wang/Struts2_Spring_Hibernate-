/*****************************************************************************
 * Copyright (c) 2015, www.qingshixun.com
 *
 * All rights reserved
 *
 *****************************************************************************/

package com.qingshixun.project.contact.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * HiberanteDao基类
 * 对Hibernate的CRUD以及分页操作进行封装，以简化子类中的数据操作
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
public class BaseHibernateDao<T, PK extends Serializable> {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    // 注入 Hibernate Session Factory
    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public BaseHibernateDao() {
        this.entityClass = getSuperClassGenricType(getClass());
    }

    /**
     * 获取当前Hibernate SessionFactory
     * 
     * @return
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * 获取当前Hibernate Session
     * 
     * @return
     */
    public Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        return session;
    }

    /**
     * 保存新增或修改实体对象.
     */
    public void save(final T entity) {
        Assert.notNull(entity, "Entity不允许为空");
        getSession().saveOrUpdate(entity);
        getSession().flush();
        logger.debug("save entity success: ", entity);
    }

    /**
     * 删除实体对象.
     */
    public void delete(final T entity) {
        Assert.notNull(entity, "Entity不允许为空！");
        getSession().delete(entity);
        getSession().flush();
        logger.debug("delete entity success: ", entity);
    }

    /**
     * 根据实体id删除对象.
     */
    public void delete(final PK id) {
        Assert.notNull(id, "id不允许为空！");
        delete(get(id));
        logger.debug("delete entity success,id is :", entityClass.getSimpleName(), id);
    }

    /**
     * 根据实体id获取对象.
     */
    public T get(final PK id) {
        Assert.notNull(id, "id不允许为空！");
        logger.debug("get entity by id: ", id);
        return (T) getSession().get(entityClass, id);
    }

    /**
     * 获取全部对象.
     */
    public List<T> getAll() {
        Criteria criteria = getSession().createCriteria(entityClass);
        logger.debug("get all entity!");
        return criteria.list();
    }

    public List<T> find(final Criterion... criterions) {
        return createCriteria(criterions).list();
    }

    /**
     * 根据Criteria查询唯一对象.
     *
     * @param criterions
     *            数量可变的Criterion.
     */
    public T findUnique(final Criterion... criterions) {
        return (T) createCriteria(criterions).uniqueResult();
    }

    /**
     * 根据指定实体属性，查询数据
     * 
     * @param propertyName
     * @param value
     * @return
     */
    public Criterion createCriterion(final String propertyName, final Object value) {
        if (value == null) {
            return Restrictions.isNull(propertyName);
        } else {
            return Restrictions.eq(propertyName, value);
        }
    }

    /**
     * 根据指定条件（Criterion），查询数据
     * 
     * @param criterions
     * @return
     */
    public Criteria createCriteria(final Criterion... criterions) {
        Criteria criteria = getSession().createCriteria(entityClass);
        for (Criterion c : criterions) {
            criteria.add(c);
        }
        return criteria;
    }

    /**
     * 通过反射, 获得定义Class时声明的父类的泛型参数的类型. 如无法找到, 返回Object.class.
     */
    public Class getSuperClassGenricType(final Class clazz) {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            logger.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        return (Class) params[0];
    }
}
