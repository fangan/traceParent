package lljk.xtrace.dubboSupport.inteceptor;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.rpc.Invocation;
import lljk.xtrace.traceContext.ThreadTraceContext;
import lljk.xtrace.traceContext.TraceContext;
import lljk.xtrace.traceFlush.TraceLog;
import lljk.xtrace.traceFlush.TraceLogWrite;
import lljk.xtrace.traceFlush.TraceLogWriteFactory;
import lljk.xtrace.traceFlush.TraceWriteName;
import lljk.xtrace.traceFlush.logType.TraceLogTypeEnum;
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
            if(StringUtils.isNotEmpty(traceId)){

                TraceContext traceContext = ThreadTraceContext.generateThreadTraceContext(traceId);

                TraceContext t = ThreadTraceContext.getThreadTraceContext();
                t.setTime(System.currentTimeMillis());

                Long currentMiles = System.currentTimeMillis();
                TraceLog traceLog = new TraceLog();
                traceLog.setLogType(TraceLogTypeEnum.beforeDubboProvider.name());
                traceLog.setAppName(t.getAppName());
                traceLog.setTraceId(t.getTraceId());

                traceLog.setTime(currentMiles);

                TraceLogWrite traceLogWrite = TraceLogWriteFactory.getTraceWrite(TraceWriteName.defaultWrite.name());
                traceLogWrite.write(traceLog);
            }

        }

    }
}
