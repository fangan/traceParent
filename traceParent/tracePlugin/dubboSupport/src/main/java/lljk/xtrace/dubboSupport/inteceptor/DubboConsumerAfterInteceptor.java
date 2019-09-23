package lljk.xtrace.dubboSupport.inteceptor;

import com.alibaba.dubbo.rpc.Result;
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
    public static void after(Object o){
        Long currentMiles = System.currentTimeMillis();

        TraceContext t = ThreadTraceContext.getThreadTraceContext();
        TraceLog traceLog = new TraceLog();
        traceLog.setLogType(TraceLogTypeEnum.beforeDubboConsume.name());
        traceLog.setAppName(t.getAppName());
        traceLog.setTraceId(t.getTraceId());
        Long spendTime = currentMiles - t.getTime();

        traceLog.setTime(spendTime);

        t.setTime(System.currentTimeMillis());


        TraceLogWrite traceLogWrite = TraceLogWriteFactory.getTraceWrite(TraceWriteName.defaultWrite.name());
        traceLogWrite.write(traceLog);


        Result result = (Result)o;
        System.out.println(22);
        System.out.println(11);
    }
}
