package com.example.clientdemo.client;

import com.example.clientdemo.thrift.LoginService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Value;

public class ThriftClient {
    private Integer port;
    private String host;
    private TTransport tTransport;
    private TProtocol tProtocol;
    private LoginService.Client client;

    private void init(){
        tTransport = new TFramedTransport(new TSocket(host, port), 600);
        tProtocol = new TCompactProtocol(tTransport);
        client = new LoginService.Client(tProtocol);
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public LoginService.Client getService(){
        return client;
    }

    public void open() throws TTransportException {
        if (null != tTransport && !tTransport.isOpen())
            tTransport.open();
    }

    public void close() {
        if (null != tTransport && tTransport.isOpen())
            tTransport.close();
    }
}
