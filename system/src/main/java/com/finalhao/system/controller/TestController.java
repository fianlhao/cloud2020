package com.finalhao.system.controller;

import com.finalhao.server.pojo.Test;
import com.finalhao.server.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @date:2020/9/3 18:36
 * @author:hao.fang Email:
 * Description:
 */
@RestController
public class TestController {
    @Autowired
    private TestService testService;
    @RequestMapping("/test/{id}")
    public List<Test> queryById(@PathVariable("id") String id) {
        return testService.queryById(id);
    }
}
