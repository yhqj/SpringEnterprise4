package chapter4.beanLife;

import org.springframework.beans.factory.*;

//1.管理Bean生命周期的接口
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public Car() {
        System.out.println("调用Car构造函数");
    }

    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public void setBrand(String brand) {
        System.out.println("调用setBrand()设置属性");
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public String getBeanName() {
        return beanName;
    }

    public void introduce() {
        System.out.println("brand" + brand + "color" + color + "maxSpeed" + maxSpeed);
    }

    //2.BeanFactoryAware接口方法
    public void setBeanFactory(BeanFactory beanFactory) {
        System.out.println("调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    //3.BeanNameAware接口方法
    public void setBeanName(String beanName) {
        System.out.println("调用BeanNameAware.setBeanFactory()");
        this.beanName = beanName;
    }


    //4.InitializingBean方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean的afterPropertiesSet()方法");
    }

    //DisposableBean的接口方法
    public void destroy() throws Exception {
        System.out.println("调用destroy（）");
    }


    public void myInit() {
        System.out.println("调用init-method所指定的myInit()");
        this.maxSpeed = 240;
    }

    public void myDestroy(){
        System.out.println("调用myDestroy()");
    }
}
