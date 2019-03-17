package lljk.xtrace.traceOption.constant;

import java.util.*;

/**
 * @Description TODO
 * @Date 2019/3/15
 * @Author fangan
 **/
public class AgentDelegateClassProfile {

    public static final Set<String> TRACE_DELEGATE_CLASS;

    static {

        String[] lib = new String[] {
                "com/alibaba/dubbo/rpc/cluster/support/AbstractClusterInvoker",


        };

        TRACE_DELEGATE_CLASS=new HashSet(Collections.unmodifiableList(Arrays.asList(lib)));

    }
}
