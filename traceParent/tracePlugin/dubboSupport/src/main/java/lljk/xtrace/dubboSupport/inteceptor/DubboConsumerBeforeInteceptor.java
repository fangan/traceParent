package lljk.xtrace.dubboSupport.inteceptor;

import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.cluster.support.AbstractClusterInvoker;
import com.alibaba.fastjson.JSON;
import lljk.xtrace.traceContext.ThreadTraceContext;
import lljk.xtrace.traceContext.TraceContext;
import lljk.xtrace.traceFlush.TraceLog;
import lljk.xtrace.traceFlush.TraceLogWrite;
import lljk.xtrace.traceFlush.TraceLogWriteFactory;
import lljk.xtrace.traceFlush.TraceWriteName;
import lljk.xtrace.traceFlush.logType.TraceLogTypeEnum;
import lljk.xtrace.traceFlush.logType.dubbo.DubboLogParamTypeEnum;
import lljk.xtrace.traceOption.constant.TraceIdProfile;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2019/3/14 下午1:07
 * @Author fangan
 **/
public class DubboConsumerBeforeInteceptor {
    public static void before(Object param,Object paramb){
        Long currentTime = System.currentTimeMillis();

        TraceContext t = ThreadTraceContext.getThreadTraceContext();
        Invocation invocation = (Invocation) param;

        AbstractClusterInvoker abstractClusterInvoker = (AbstractClusterInvoker)paramb;

        Map<String, String> attachment =  invocation.getAttachments();
        attachment.put(TraceIdProfile.traceIdName,t.getTraceId());

        Map<String,Object> map = new HashMap<String, Object>();

        Object[] arguments = invocation.getArguments();
        Class<?>[] parameterTypes = invocation.getParameterTypes();
        String interfaceName = abstractClusterInvoker.getInterface().getName();
        String methodName = invocation.getMethodName();

        map.put(DubboLogParamTypeEnum.arguments.name(),arguments);
        map.put(DubboLogParamTypeEnum.parameterTypes.name(),parameterTypes);
        map.put(DubboLogParamTypeEnum.interfaceName.name(),interfaceName);
        map.put(DubboLogParamTypeEnum.methodName.name(),methodName);

        TraceLog traceLog = new TraceLog();
        traceLog.setLogType(TraceLogTypeEnum.beforeDubboConsumer.name());
        traceLog.setAppName(t.getAppName());
        traceLog.setTraceId(t.getTraceId());
        traceLog.setParam(map);
        traceLog.setTime(currentTime);

        TraceLogWrite traceLogWrite = TraceLogWriteFactory.getTraceWrite(TraceWriteName.defaultWrite.name());
        traceLogWrite.write(traceLog);

    }

}
