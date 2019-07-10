package suishen.suishen.dubbo.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import suishen.suishen.dubbo.consumer.service.ConsumerService;

/**
 * @author liweiyuan
 * @description
 * @date 2019/7/9
 */
@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;


    @GetMapping("/consumer")
    public String consumer() {
        return consumerService.receiveMsg();
    }
}
