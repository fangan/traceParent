package lljk.xtrace.traceOption.constant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description TODO
 * @Date 2019/3/15
 * @Author fangan
 **/
public class AgentUsedClassProfile {

    public static final List<String> TRACE_AGENT_CLASS;

    static {
        String[] lib = new String[] {
                "lljk.xtrace",
                "com.alibaba.fastjson",
                "org.objectweb.asm",
                "org.apache.kafka",

                "org.jboss.netty",

                "javassist",

                "org.slf4j",
                "org.apache.thrift",

                "org.aopalliance",

                "org.apache.commons.lang",
                "org.apache.log4j",

        };

        TRACE_AGENT_CLASS = Collections.unmodifiableList(Arrays.asList(lib));
    }
}
