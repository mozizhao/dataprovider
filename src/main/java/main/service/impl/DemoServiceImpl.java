package main.service.impl;

import main.service.DemoService;

public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "hello " + name;
    }
}
