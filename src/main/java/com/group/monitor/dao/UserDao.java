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
     * @param: userPO
     * @return:
     */
    void insert(UserPO userPO);
    /**
     * @Description:用户登陆
     * @param:name
     * @param:password
     * @return:UserPO
     */
    UserPO getUser(@Param(value = "name") String name, @Param(value = "password") String password);
    /**
     * @Description:通过用户名进行查找
     * @param: name
     * @return:UserPO
     */
    UserPO getName(String name);
}
