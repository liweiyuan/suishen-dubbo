package suishen.dubbo.filter;

import org.apache.dubbo.common.Constants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * @author liweiyuan
 * @description
 * @date 2019/7/10
 */
@Activate(group = {Constants.PROVIDER, Constants.CONSUMER}, order = -3)
public class CallTraceFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        String traceId = RpcContext.getContext().getAttachment("traceId");

        if (traceId == null) {
            //设置
            RpcContext.getContext().setAttachment("traceId", Thread.currentThread().getName());

            boolean consumerSide = RpcContext.getContext().isConsumerSide();
            if (consumerSide) {
                System.out.println("current is consumer,the traceId is " + Thread.currentThread().getName());
            }
        } else {
            boolean consumerSide = RpcContext.getContext().isConsumerSide();
            if (!consumerSide) {
                System.err.println("current is provider,the traceId is " + traceId);
            }
        }
        return invoker.invoke(invocation);
    }
}

//http://wuwenliang.net/2019/02/21/%E8%87%AA%E5%B7%B1%E5%86%99dubbo%E9%93%BE%E8%B7%AF%E8%BF%BD%E8%B8%AA%E5%B7%A5%E5%85%B7%E5%8C%85-%E5%AE%9E%E7%8E%B0dubbo%E8%B0%83%E7%94%A8%E4%B8%AD%E4%BC%A0%E9%80%92%E6%89%93%E5%8D%B0TraceId-%E5%BC%80%E5%8F%91%E5%8F%8A%E5%8E%9F%E7%90%86%E7%AF%87/
//自定义trace传递
