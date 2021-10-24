package com.smart.proxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformceHandler implements InvocationHandler {
    private Object target;

    public PerformceHandler(Object object) {  //target作为目标类
        this.target = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName()+"."+method.getName());
        Object obj = method.invoke(target,args);
        PerformanceMonitor.end();

        return obj;
    }
}
