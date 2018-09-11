package mySpringMVC.AWARE;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean(name="testDemo")
    public Demo2 generateDemo() {
        Demo2 demo = new Demo2();
        demo.setId(12345);
        demo.setName("test");
        return demo;
    }
}

