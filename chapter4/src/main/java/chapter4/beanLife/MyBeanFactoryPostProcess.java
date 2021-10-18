package chapter4.beanLife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcess implements BeanFactoryPostProcessor {
    //对car <bean> 的brand属性信息进行 "偷梁换柱" 的加工操作
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition bd = beanFactory.getBeanDefinition("car");

        bd.getPropertyValues().add("brand","奇瑞qq");
        System.out.println("调用BeanFactoryPostProcessor.postProcessBeanFactory()");
    }
}
