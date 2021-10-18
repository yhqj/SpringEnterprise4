package chapter4.beanLife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.Order;

@Order(10)
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("car")) {
            Car car = (Car) bean;
            if (car.getColor() == null || car.getColor().equals("")) {
                System.out.println("color为空，设置默认黑色");
                car.setColor("黑色");
            }
        }
        System.out.println("调用postProcessBeforeInitialization 将color设置为黑色");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (beanName.equals("car")) {
            Car car = (Car) bean;
            if (car.getColor() == null || car.getColor().equals("")) {
                System.out.println("color为空，设置默认黑色");
                car.setColor("黑色");
            }
        }
        System.out.println("postProcessAfterInitialization 将速度200");
        return bean;
    }
}