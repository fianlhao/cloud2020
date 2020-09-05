package com.finalhao.server.service.impl;

import com.finalhao.server.dao.TestDao;
import com.finalhao.server.dao.TestMapper;
import com.finalhao.server.pojo.Test;
import com.finalhao.server.pojo.TestExample;
import com.finalhao.server.pojo.User;
import com.finalhao.server.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date:2020/9/3 15:40
 * @author:hao.fang Email:
 * Description:
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> queryById(String id) {
        TestExample testExample = new TestExample();
        testExample.createCriteria().andIdEqualTo(id);
        return testMapper.selectByExample(testExample);
    }
}
