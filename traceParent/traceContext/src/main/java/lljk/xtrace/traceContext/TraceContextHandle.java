package lljk.xtrace.traceContext;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Description TODO
 * @Date 2019/5/7
 * @Author fangan
 **/
public class TraceContextHandle {
    private static  AtomicBoolean handleFlag = new AtomicBoolean(false);
    private static ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    public static void handle(){

        if(handleFlag.get()){
            return;
        }
        service.schedule(new Runnable() {
            public void run() {
                Map<Thread,TraceContext> map = TraceMap.contextMap;
                for(Map.Entry entry : map.entrySet()){
                  Thread thread =   (Thread)entry.getKey();
                  if(!thread.isAlive()){
                      map.remove(thread);
                  }
                }
            }
        }, 10, TimeUnit.SECONDS);

        handleFlag = new AtomicBoolean(true);
    }


}
