package lljk.xtrace.traceFlush;

/**
 * @Description TODO
 * @Date 2019/5/8
 * @Author fangan
 **/
public class TraceLogWriteFactory {

    public static TraceLogWrite getTraceWrite(String name){
        if(TraceWriteName.defaultWrite.name().equals(name)){
            return DefaultTraceLogWrite.getTraceWrite();
        }
        return null;
    }
}
