package ru.ankoks.screensaver;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * User: ankoks
 * Date: 01.10.2018
 */
@Configuration
@ComponentScan(basePackages = "ru.ankoks.screensaver")
public class Config {

    @Bean
    @Scope(value = "periodical")
    public Color color() {
        Random random  = new Random();

        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Bean
    public ColorFrame frame() {
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();
            }
        };
    }


    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        while (true) {
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(100);
        }
    }
}
