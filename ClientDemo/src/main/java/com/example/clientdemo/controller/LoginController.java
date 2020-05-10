package com.example.clientdemo.controller;

import com.example.clientdemo.Service.ServiceInfo.LoginServiceInf;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 入参的绑定，简单类型，json,bean,json和bean的转换
 * ResponseBody为什么返回json
 */
@Controller
@RequestMapping("/thrift")
public class LoginController {

    @Autowired
    LoginServiceInf loginService;

    @RequestMapping("/get")
    @ResponseBody
    public Map<String, String> print(String username, String passwd) throws TException {
        Map<String, String> map = new HashMap<>();
        map.put(username, loginService.getRequestBy(username, passwd));
        return map;
    }
}
