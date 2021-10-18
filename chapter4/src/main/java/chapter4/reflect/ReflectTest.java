package chapter4.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
    public static Car initByDefaultConst() throws Throwable {

        //通过类加载器获取Carl类对象
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz  = classLoader.loadClass("chapter4.reflect.Car");

        //获取类的默认构造器对象并通过它实例Car
        Constructor cons = clazz.getDeclaredConstructor((Class<?>[]) null);
        Car car = (Car) cons.newInstance();

        //通过反射方法设置熟悉
        Method setBrand = clazz.getMethod("setBrand",String.class);
        setBrand.invoke(car,"红旗");

        //类似的方法

        return car;
    }

    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConst();
        car.introduce();
    }
}
