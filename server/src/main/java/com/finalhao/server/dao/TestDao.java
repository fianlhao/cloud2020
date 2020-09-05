package com.finalhao.server.dao;


import com.finalhao.server.pojo.User;

import java.util.List;

/**
 * @date:2020/9/3 15:36
 * @author:hao.fang Email:
 * Description:
 */
public interface TestDao {

    List<User> queryById(String id);
}
