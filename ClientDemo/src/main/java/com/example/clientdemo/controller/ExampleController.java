package com.example.clientdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shallin
 */

@Controller
public class ExampleController {
    @RequestMapping("/index")
    @ResponseBody
    public Map<String, String> index(){
        Map<String, String> map = new HashMap<>();
        map.put("username", "shallin");
        map.put("passwd", "123456");
        return map;
    }
}
