package suishen.suishen.dubbo.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = {"suishen.suishen.dubbo.consumer.service"})
public class SuishenDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuishenDubboConsumerApplication.class, args);
    }

}
