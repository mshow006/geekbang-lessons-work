package org.geektimes.projects.user.service;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.sql.LocalTransactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserServiceImpl implements UserService {

    @Resource(name = "bean/EntityManager")
    private EntityManager entityManager;

//    @Resource(name = "bean/Validator")
//    private Validator validator;

    @Override
    // 默认需要事务
    @LocalTransactional
    public boolean register(User user) {
        // before process
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // 主调用
        try {
            entityManager.persist(user);
        } catch (Exception e) {
            transaction.rollback();
            return false;
        }


        // 调用其他方法方法
//        update(user); // 涉及事务

        // after process
         transaction.commit();

        return true;
    }

    @Override
    public boolean deregister(User user) {
        return false;
    }

    @Override
    @LocalTransactional
    public boolean update(User user) {
        return false;
    }

    @Override
    public User queryUserById(Long id) {
        return null;
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return null;
    }
}
