package com.finalhao.server.service;


import com.finalhao.server.pojo.Test;
import com.finalhao.server.pojo.User;

import java.util.List;

/**
 * @date:2020/9/3 15:38
 * @author:hao.fang Email:
 * Description:
 */
public interface TestService {
    List<Test> queryById(String id);
}
