package lljk.xtrace.traceOption.agentClssProfile;

import lljk.xtrace.traceOption.constant.AgentUsedClassProfile;

/**
 * @Description TODO
 * @Date 2019/3/15 下午6:23
 * @Author fangan
 **/
public class DefaultAgentJarClass implements AgentJarClass{
    private boolean IS_LOAD_CLASS = true;
    private boolean NOT_LOAD_CLASS = false;


    private static DefaultAgentJarClass agentJarClass;

    public boolean isAgentJarClass(String className) {

        int size = AgentUsedClassProfile.TRACE_AGENT_CLASS.size();
        for (int i = 0; i < size; i++) {
            if (className.startsWith(AgentUsedClassProfile.TRACE_AGENT_CLASS.get(i))) {
                return IS_LOAD_CLASS;
            }
        }
        return NOT_LOAD_CLASS;

    }
}
