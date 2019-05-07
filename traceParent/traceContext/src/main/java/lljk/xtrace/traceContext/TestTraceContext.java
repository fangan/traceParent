package lljk.xtrace.traceContext;

import java.util.Map;

/**
 * @Description TODO
 * @Date 2019/5/6
 * @Author fangan
 **/
public class TestTraceContext {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            Thread t= new Thread(new Runnable() {
                public void run() {
                    TraceContext traceContext = ThreadTraceContext.getThreadTraceContext();
                    System.out.println(traceContext.getTraceId());
                    System.out.println(traceContext.getAppName());
                    System.out.println(traceContext.getProp());
                    System.out.println(traceContext.getTime());
                    try {
                        Thread.sleep(500000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<Thread,TraceContext> m = TraceMap.contextMap;

        for(Map.Entry entry : m.entrySet()){
          Thread ta =  (Thread)entry.getKey();
          TraceContext context =  (TraceContext) entry.getValue();
            System.out.println(ta.isAlive());


        }

        System.out.println(m);
    }
}
