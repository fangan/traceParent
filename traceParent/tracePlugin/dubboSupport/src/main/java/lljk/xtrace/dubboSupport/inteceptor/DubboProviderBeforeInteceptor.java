package lljk.xtrace.dubboSupport.inteceptor;

import com.alibaba.dubbo.rpc.Invocation;
import lljk.xtrace.traceContext.ThreadTraceContext;
import lljk.xtrace.traceContext.TraceContext;
import lljk.xtrace.traceOption.constant.TraceIdProfile;

import java.util.Map;

/**
 * @Description TODO
 * @Date 2019/3/14 下午1:07
 * @Author fangan
 **/
public class DubboProviderBeforeInteceptor {
    public static void before(Object o){
        Invocation invocation = (Invocation)o;
        Map<String, String> attachments = invocation.getAttachments();
        if(attachments != null){
            String traceId = attachments.get(TraceIdProfile.traceIdName);
            ThreadTraceContext.generateThreadTraceContext(traceId);
        }

    }
}
