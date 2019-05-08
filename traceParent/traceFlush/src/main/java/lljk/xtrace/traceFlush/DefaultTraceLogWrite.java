package lljk.xtrace.traceFlush;

/**
 * @Description TODO
 * @Date 2019/5/8
 * @Author fangan
 **/
public class DefaultTraceLogWrite implements TraceLogWrite{
    private DefaultTraceLogWrite(){

    }
    private static TraceLogWrite traceLogWrite;

    public static TraceLogWrite getTraceWrite(){
        if(traceLogWrite != null){
            return traceLogWrite;
        }else{
            synchronized (DefaultTraceLogWrite.class){
                if(traceLogWrite != null){
                    return traceLogWrite;
                }else{
                    return new DefaultTraceLogWrite();

                }
            }
        }
    }
    public void write(TraceLog traceLog) {

    }
}
