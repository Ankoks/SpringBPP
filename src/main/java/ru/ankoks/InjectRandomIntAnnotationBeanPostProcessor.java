package ru.ankoks;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * User: ankoks
 * Date: 26.09.2018
 */
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    //before INIT method
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        Field[] fields = o.getClass().getDeclaredFields();

        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);

            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();

                Random random = new Random();
                int i = min + random.nextInt(max - min);

                field.setAccessible(true);

                ReflectionUtils.setField(field, o, i);
            }
        }

        return o;
    }

    //after INIT method
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
