package suishen.dubbo.filter;

import org.apache.dubbo.common.Constants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * @author liweiyuan
 * @description
 * @date 2019/7/10
 */
@Activate(group = {Constants.PROVIDER}, order = -1)
public class DubboProviderFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String jar = invoker.getUrl().getParameter("jar", "");

        System.err.println("provider : " + jar);
        return invoker.invoke(invocation);
    }
}
