package suishen.suishen.dubbo.provider.service;


import org.apache.dubbo.config.annotation.Service;
import suishen.common.HelloService;

/**
 * @author liweiyuan
 * @description
 * @date 2019/7/9
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        return "say hello";
    }
}
