package suishen.suishen.dubbo.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = {"suishen.suishen.dubbo.provider.service"})
public class SuishenDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuishenDubboProviderApplication.class, args);
    }

}
