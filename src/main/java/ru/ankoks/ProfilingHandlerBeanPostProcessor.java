package ru.ankoks;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * User: ankoks
 * Date: 26.09.2018
 */
public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Class> map = new HashMap<>();

    private ProfilingController controller = new ProfilingController();

    public ProfilingHandlerBeanPostProcessor() throws Exception {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();

        platformMBeanServer.registerMBean(controller, new ObjectName("profiling", "name", "my"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {

        Class<?> beanClass = o.getClass();
        if (beanClass.isAnnotationPresent(Profiling.class)) {
            map.put(s, beanClass);
        }

        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        Class beanClass = map.get(s);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> {
                if (controller.isEnabled()) {
                    System.out.println("Профилирую...");
                    long before = System.nanoTime();

                    Object retVal = method.invoke(o, args);

                    System.out.println(System.nanoTime() - before);
                    System.out.println("Все");
                    return retVal ;
                } else {
                    return method.invoke(o, args);
                }
            });
        }
        return o;
    }
}
