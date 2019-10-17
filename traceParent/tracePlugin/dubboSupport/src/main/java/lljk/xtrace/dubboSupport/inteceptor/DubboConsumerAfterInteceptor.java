package lljk.xtrace.dubboSupport.inteceptor;

import com.alibaba.dubbo.rpc.Result;
import com.alibaba.fastjson.JSON;
import lljk.xtrace.traceContext.ThreadTraceContext;
import lljk.xtrace.traceContext.TraceContext;
import lljk.xtrace.traceFlush.TraceLog;
import lljk.xtrace.traceFlush.TraceLogWrite;
import lljk.xtrace.traceFlush.TraceLogWriteFactory;
import lljk.xtrace.traceFlush.TraceWriteName;
import lljk.xtrace.traceFlush.logType.TraceLogTypeEnum;

/**
 * @Description TODO
 * @Date 2019/3/14 下午1:07
 * @Author fangan
 **/
public class DubboConsumerAfterInteceptor {
    public static void after(){

        Long currentMiles = System.currentTimeMillis();

        TraceContext t = ThreadTraceContext.getThreadTraceContext();
        TraceLog traceLog = new TraceLog();
        traceLog.setLogType(TraceLogTypeEnum.afterDubboConsumer.name());
        traceLog.setAppName(t.getAppName());
        traceLog.setTraceId(t.getTraceId());

        traceLog.setTime(currentMiles);

        TraceLogWrite traceLogWrite = TraceLogWriteFactory.getTraceWrite(TraceWriteName.defaultWrite.name());
        traceLogWrite.write(traceLog);

    }
}
