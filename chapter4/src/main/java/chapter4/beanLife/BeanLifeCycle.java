package chapter4.beanLife;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;


public class BeanLifeCycle {
    private static void lifeCycleInBeanFactory() {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:com/smart/beans2.xml");

        BeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory) beanFactory);
        reader.loadBeanDefinitions(resource);

        //
        ((ConfigurableBeanFactory) beanFactory).addBeanPostProcessor(new MyBeanPostProcessor());
        ((ConfigurableBeanFactory) beanFactory).addBeanPostProcessor(new MyInstantionAwareBeanPostProessor());

        //第一次从容器中获取car,触发容器化实例化该Bean,这将引发Bean生命周期方法的调用
        Car car1 = (Car) beanFactory.getBean("car");
        car1.introduce();
        car1.setColor("红色");

        //第二次直接从缓存池中获取
        Car car2 = (Car) beanFactory.getBean("car");

        System.out.println("car1==car2"+(car1==car2));

        ((DefaultListableBeanFactory) beanFactory).destroySingletons();
    }

    public static void main(String[] args) {
        lifeCycleInBeanFactory();
    }
}
