package chapter4.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrivateCarReflect {
    public static void main(String[] args) throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("chapter4.reflect.PrivateCar");
        PrivateCar pcar = (PrivateCar) clazz.newInstance();
        Field colorFld = clazz.getDeclaredField("color");

        colorFld.setAccessible(true);
        colorFld.set(pcar," red");

        Method driveMtd = clazz.getDeclaredMethod("drive",(Class<?>[]) null);

        driveMtd.setAccessible(true);
        driveMtd.invoke(pcar,(Object[])null);

    }
}
