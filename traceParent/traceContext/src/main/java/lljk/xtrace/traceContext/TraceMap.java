package lljk.xtrace.traceContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2019/5/6
 * @Author fangan
 **/
public class TraceMap {
    public static Map<Thread,TraceContext> contextMap = new HashMap();
}
