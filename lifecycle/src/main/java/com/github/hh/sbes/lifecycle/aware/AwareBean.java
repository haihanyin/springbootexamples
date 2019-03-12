package com.github.hh.sbes.lifecycle.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class AwareBean implements ApplicationContextAware,
        ApplicationEventPublisherAware, BeanClassLoaderAware,
        BeanFactoryAware, LoadTimeWeaverAware, MessageSourceAware,
        NotificationPublisherAware, ResourceLoaderAware, BeanNameAware {


    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader:" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory:" + beanFactory);
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("setBeanName:" + s);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext:"+applicationContext);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("setApplicationEventPublisher:" + applicationEventPublisher);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("setMessageSource:" + messageSource);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("setResourceLoader:" + resourceLoader);
    }

    @Override
    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
        System.out.println("setLoadTimeWeaver:" + loadTimeWeaver);
    }

    @Override
    public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
        System.out.println("setNotificationPublisher:" + notificationPublisher);
    }
}
