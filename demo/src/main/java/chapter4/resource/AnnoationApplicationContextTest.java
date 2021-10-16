package chapter4.resource;

import chapter4.config.Beans;
import chapter4.reflect.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnoationApplicationContextTest {


    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car car = ctx.getBean("car",Car.class);
        car.introduce();
    }
}
