package chapter4.beanLife;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.core.annotation.Order;

import java.beans.PropertyDescriptor;

@Order(5)
public class MyInstantionAwareBeanPostProessor extends InstantiationAwareBeanPostProcessorAdapter {

//    //在实例化Bean前调用
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        //1.仅对容器中得car Bean处理 ps:注解类
//        if ("car".equals(beanName)) {
//            System.out.println("InstantiationAware postProcessBeforeInitialization");
//        }
//        return bean;
//    }
//
//    //在实例化Bean后调用
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//
//        if ("car".equals(beanName)) {
//            System.out.println("InstantiationAware postProcessBeforeInitialization");
//        }
//        return bean;
//    }

    @Override
    public PropertyValues postProcessPropertyValues(
            PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
            throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAware postProcessPropertyValues");
        }
        return pvs;
    }


    @Override
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
        if("car".equals(beanName)){
            System.out.println("MyInstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)){
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation");
        }
        return true;
    }
//
//    @Override
//    public PropertyValues postProcessPropertyValues(
//            PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
//            throws BeansException {
//        if("car".equals(beanName)){
//            System.out.println("InstantiationAwareBeanPostProcessor.postProcessPropertyValues");
//        }
//        return pvs;
//    }
//
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        return bean;
//    }
}
