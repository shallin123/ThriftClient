package com.example.clientdemo.Service.ServiceInfo;

import org.apache.thrift.TException;

public interface LoginServiceInf {
    String getRequestBy(String username, String passwd) throws TException;
}
