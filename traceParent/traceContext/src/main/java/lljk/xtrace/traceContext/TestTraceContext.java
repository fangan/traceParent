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

                }
            });
            t.start();
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadLocal<TraceContext> m = TraceMap.contextMap;



        System.out.println(m);
    }
}
