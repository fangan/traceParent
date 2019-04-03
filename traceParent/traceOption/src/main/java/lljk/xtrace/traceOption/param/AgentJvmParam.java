package lljk.xtrace.traceOption.param;

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
public class AgentJvmParam {
    public static String agentPath;
    public static String appName;

    public AgentJvmParam(){
        agentPath=findTraceAgentPath();
        appName=findTraceAgentAppName();
    }

    protected String findTraceAgentPath(){

        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        List<String> inputArguments = runtimeMXBean.getInputArguments();
        for (String inputArgument : inputArguments) {
            if (isTraceAgent(inputArgument, AgentParamPattern.DEFAULT_AGENT_PATTERN)) {
                return removeJavaAgentPrefix(AgentParamPattern.JAVA_AGENT_VM_PARAM_START,inputArgument);
            }
        }
        return null;
    }

    protected String findTraceAgentAppName(){

        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        List<String> inputArguments = runtimeMXBean.getInputArguments();
        for (String inputArgument : inputArguments) {

            if (isTraceAgentAppName(inputArgument, AgentParamPattern.DEFAULT_AGENT_PATTERN)) {
                return removeJavaAgentPrefix(AgentParamPattern.JAVA_AGENT_APP_NAME_START,inputArgument);
            }
        }
        return null;
    }


    protected  boolean isTraceAgent(String inputArgument, Pattern javaPattern) {
        if (!inputArgument.startsWith(AgentParamPattern.JAVA_AGENT_VM_PARAM_START)) {
            return false;
        }
        Matcher matcher = javaPattern.matcher(inputArgument);
        return matcher.find();
    }

    protected  boolean isTraceAgentAppName(String inputArgument, Pattern javaPattern) {
        if (!inputArgument.startsWith(AgentParamPattern.JAVA_AGENT_APP_NAME_START)) {
            return false;
        }
        return true;
    }


    protected  String removeJavaAgentPrefix(String start,String inputArgument) {
        return inputArgument.substring(start.length(), inputArgument.length());
    }

    public String getAgentPath() {
        return agentPath;
    }

    public String getAppName() {
        return appName;
    }

}
