package lljk.xtrace.boot;


import lljk.xtrace.traceOption.agentClssProfile.AgentJarClass;
import lljk.xtrace.traceOption.agentClssProfile.DefaultAgentJarClass;
import lljk.xtrace.traceOption.agentPath.AgentPath;
import lljk.xtrace.traceOption.loader.DefaultTraceClassLoader;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.net.URL;

/**
 * @Description TODO
 * @Date 2019/3/13 下午9:03
 * @Author fangan
 **/
public class TracePremain {

    public static void premain(String agentArgs, Instrumentation inst){
        AgentPath agentPath = new AgentPath();
        URL url = agentPath.getAgentUrl();
        AgentJarClass agentJarClass = new DefaultAgentJarClass();
        ClassLoader classLoader = new DefaultTraceClassLoader(new URL[]{url},TracePremain.class.getClassLoader(),agentJarClass);

        ClassFileTransformer trans =  new TraceClassFileTransformer(classLoader);

        inst.addTransformer(trans);
    }

}
