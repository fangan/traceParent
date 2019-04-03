package lljk.xtrace.boot;


import lljk.xtrace.traceOption.agentClssProfile.AgentJarClass;
import lljk.xtrace.traceOption.agentClssProfile.DefaultAgentJarClass;
import lljk.xtrace.traceOption.param.AgentParam;
import lljk.xtrace.traceOption.param.AgentJvmParam;
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
        AgentParam agentParam = new AgentParam();
        AgentJarClass agentJarClass = new DefaultAgentJarClass();
        ClassLoader agentClassLoader = new DefaultTraceClassLoader(agentParam.getAgentUrls(),TracePremain.class.getClassLoader(),agentJarClass);
        ClassFileTransformer trans =  new TraceClassFileTransformer(agentClassLoader);
        inst.addTransformer(trans);
    }

}
