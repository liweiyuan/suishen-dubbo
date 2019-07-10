package suishen.dubbo.filter;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.apache.dubbo.common.Constants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author liweiyuan
 * @description
 * @date 2019/7/10
 */
@Activate(group = {Constants.CONSUMER}, order = -2)
public class JarVersionAttachFilter implements Filter {

    private LoadingCache<Class<?>, String> versionMapping = CacheBuilder.newBuilder().maximumSize(1024).build(new CacheLoader<Class<?>, String>() {
        @Override
        public String load(Class<?> key) throws Exception {
            return "";
        }
    });

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Map<String, String> attachments = invocation.getAttachments();
        String version = versionMapping.getUnchecked(invoker.getInterface());
        if (StringUtils.hasText(version)) {
            attachments.put("version", version);
        }

        invoker.getUrl().addParameterIfAbsent("jar","version");
        return invoker.invoke(invocation);
    }
}
