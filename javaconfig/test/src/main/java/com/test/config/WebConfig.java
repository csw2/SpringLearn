package com.test.config;

import com.test.interfaces.WebParameter;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.Set;

@HandlesTypes({WebParameter.class})
public class WebConfig implements ServletContainerInitializer {
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        Iterator var4;
        if (set!=null){
            var4=set.iterator();
            while(var4.hasNext()){
                Class<?> clazz= (Class<?>) var4.next();
                if (!clazz.isInterface()&& !Modifier.isAbstract(clazz.getModifiers())&&WebParameter.class.isAssignableFrom(clazz)){
                    try {
                        ((WebParameter) clazz.newInstance()).loadOnstarp(servletContext);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
