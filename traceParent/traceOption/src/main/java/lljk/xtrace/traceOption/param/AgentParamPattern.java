package lljk.xtrace.traceOption.param;

import java.util.regex.Pattern;

/**
 * @Description TODO
 * @Date 2019/3/15 下午10:40
 * @Author fangan
 **/
public class AgentParamPattern {

    static final String JAVA_AGENT_VM_PARAM_START = "-javaagent:";

    static final String JAVA_AGENT_APP_NAME_START = "-agentappname:";

    static final Pattern DEFAULT_AGENT_PATTERN = compile("traceAgent-1.0-SNAPSHOT"+"\\.jar");

    private static Pattern compile(String regex) {
        return Pattern.compile(regex);
    }
}
