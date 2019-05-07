package lljk.xtrace.dubboSupport.inteceptor;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.dubbo.rpc.Invocation;
import lljk.xtrace.traceContext.ThreadTraceContext;
import lljk.xtrace.traceContext.TraceContext;
import lljk.xtrace.traceContext.TraceMap;

import java.util.Map;

/**
 * @Description TODO
 * @Date 2019/3/14 下午1:07
 * @Author fangan
 **/
public class DubboConsumerBeforeInteceptor {
    public static void before(Object param){
        TraceContext t = ThreadTraceContext.getThreadTraceContext();
        Invocation invocation = (Invocation) param;
        Map<String, String> attachment =  invocation.getAttachments();
        attachment.put("lljkTraceId",t.getTraceId());

        Object[] argument = invocation.getArguments();
        Class<?>[] parameterType = invocation.getParameterTypes();
        Class clazz = invocation.getInvoker().getInterface();
        String interfaceName = clazz.getName();
        String methodName = invocation.getMethodName();





    }
}
