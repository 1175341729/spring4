package com.spring.study.aware;

import com.spring.study.config.BeanConfig;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware {
    private String beanName;
    private ResourceLoader loader;
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void outputResult(){
        System.out.println("beanName:" + beanName);
        try {
            InputStream inputStream = loader.getResource("classpath:text.txt").getInputStream();
            String content = IOUtils.toString(inputStream);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResult();
    }
}
