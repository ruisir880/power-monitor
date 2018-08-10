package com.group.monitor.dao;

import com.group.monitor.entity.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * @Description:用户dao接口
 */
@Mapper
@Repository
public interface UserDao {
    /**
     * @Description:用户注册
     */
    void insert(UserPO userPO);
    /**
     * @Description:用户登陆
     */
    UserPO getUser(@Param(value = "name") String name, @Param(value = "password") String password);
    /**
     * @Description:通过用户名进行查找
     */
    UserPO getName(String name);
}
