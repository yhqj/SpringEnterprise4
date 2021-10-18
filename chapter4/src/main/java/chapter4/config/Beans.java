package chapter4.config;

import chapter4.reflect.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean(name = "car")
    public Car buildCar() {
        Car car = new Car();
        car.setBrand("bmw");
        car.setColor("blank");
        return car;
    }
}
