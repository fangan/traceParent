package lljk.xtrace.traceOption.agentPath;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description TODO
 * @Date 2019/3/15 下午10:37
 * @Author fangan
 **/
public class AgentPath {

    private String findTraceAgentPath(){

        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        List<String> inputArguments = runtimeMXBean.getInputArguments();
        for (String inputArgument : inputArguments) {
            if (isTraceAgent(inputArgument, AgentParamPattern.DEFAULT_AGENT_PATTERN)) {
                return removeJavaAgentPrefix(inputArgument);
            }
        }
        return null;
    }


    private  boolean isTraceAgent(String inputArgument, Pattern javaPattern) {
        if (!inputArgument.startsWith(AgentParamPattern.JAVA_AGENT_VM_PARAM_START)) {
            return false;
        }
        Matcher matcher = javaPattern.matcher(inputArgument);
        return matcher.find();
    }

    public  URL getAgentUrl() {
        String path = findTraceAgentPath();
        try {
            URL url = new URL("file:"+path);
            return url;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private  String removeJavaAgentPrefix(String inputArgument) {
        return inputArgument.substring(AgentParamPattern.JAVA_AGENT_VM_PARAM_START.length(), inputArgument.length());
    }
}
