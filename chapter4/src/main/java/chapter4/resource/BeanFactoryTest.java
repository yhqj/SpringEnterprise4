package chapter4.resource;

import chapter4.reflect.Car;
import com.sun.org.apache.xml.internal.security.utils.resolver.ResourceResolver;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

public class BeanFactoryTest {
    public static void getBean() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:com/smart/beans1.xml");
        System.out.println(resource.getURL());

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);

        Car car = factory.getBean("car1",Car.class);
        System.out.println("car bean in ready");
        car.introduce();
    }

    public static void main(String[] args) throws IOException {
        getBean();
    }
}
