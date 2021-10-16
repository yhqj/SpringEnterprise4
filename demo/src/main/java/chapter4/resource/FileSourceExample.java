package chapter4.resource;

import java.io.IOException;

import org.springframework.core.io.*;

public class FileSourceExample {
    public static void main(String[] args) {
        String filePath = "";

        //使用系统路径方式加载文件
        WritableResource res1 = new PathResource(filePath);

        //使用类路径方式加载文件
        Resource res2 = new ClassPathResource("");


    }
}
