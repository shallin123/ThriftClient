package com.example.clientdemo.Service;

import com.example.clientdemo.Service.ServiceInfo.LoginServiceInf;
import com.example.clientdemo.client.ThriftClient;
import com.example.clientdemo.thrift.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginServiceInf {
    private static Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    ThriftClient thriftClient;

    @Override
    public String getRequestBy(String username, String passwd){
       try {
           thriftClient.open();
           log.info("客户端请求用户名为" + username + "的数据");
           Request request = new Request(username, passwd);
           return thriftClient.getService().doAction(request);
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           thriftClient.close();
       }
       return null;
    }
}
