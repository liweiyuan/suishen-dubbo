package suishen.dubbo.filter;


import org.apache.dubbo.common.Constants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * @author liweiyuan
 * @description
 * @date 2019/7/9
 */
@Activate(group = {Constants.CONSUMER}, order = -1)
public class DubboTracerFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        System.err.println("hello");
        return invoker.invoke(invocation);
    }
}
