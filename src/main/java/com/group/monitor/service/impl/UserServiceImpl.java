package com.group.monitor.service.impl;

import com.group.monitor.dao.UserDao;
import com.group.monitor.entity.UserPO;
import com.group.monitor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * @Description:用户注册
     * @param: userPO
     * @return:
     */
    @Override
    public void save(UserPO userPO) {
        userDao.insert(userPO);
    }

    /**
     * @Description:
     * @param: name
     * @param password
     * @return:UserPO
     */
    @Override
    public UserPO getUser(String name, String password) {
        return userDao.getUser(name,password);
    }

    @Override
    public UserPO getName(String name) {
        return userDao.getName(name);
    }

}
