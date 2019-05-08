package lljk.xtrace.traceFlush;

/**
 * @Description TODO
 * @Date 2019/5/8
 * @Author fangan
 **/
public class TraceLogWriteFactory {

    private static TraceLogWrite defaultTraceLogWrite = new DefaultTraceLogWrite();

    public static TraceLogWrite getTraceWrite(String name){
        if(TraceWriteName.defaultWrite.name().equals(name)){
            return defaultTraceLogWrite;
        }
        return null;
    }
}
