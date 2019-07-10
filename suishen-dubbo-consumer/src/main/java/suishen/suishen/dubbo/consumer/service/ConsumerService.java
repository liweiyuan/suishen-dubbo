package suishen.suishen.dubbo.consumer.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import suishen.common.HelloService;

/**
 * @author liweiyuan
 * @description
 * @date 2019/7/9
 */
@Service
public class ConsumerService {

    @Reference
    private HelloService helloService;

    public String receiveMsg(){
        return helloService.sayHello();
    }
}
