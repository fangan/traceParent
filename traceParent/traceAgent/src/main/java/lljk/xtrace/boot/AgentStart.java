package lljk.xtrace.boot;


import lljk.xtrace.traceOption.dispatcher.DefaultDispatcherTransform;
import lljk.xtrace.traceOption.dispatcher.DispatcherTransform;

import java.security.ProtectionDomain;

/**
 * @Description TODO
 * @Date 2019/3/17
 * @Author fangan
 **/
public class AgentStart {
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer, ClassLoader agentClassLoader){

        DispatcherTransform dispatcherTransform = new DefaultDispatcherTransform();
        return dispatcherTransform.transform(loader,className,classBeingRedefined,protectionDomain,classfileBuffer,agentClassLoader);


    }




}
