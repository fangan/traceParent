package lljk.xtrace.boot;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @Description TODO
 * @Date 2019/3/14
 * @Author fangan
 **/
public class TraceClassFileTransformer implements ClassFileTransformer {
    private ClassLoader agentLoader;
    public TraceClassFileTransformer(ClassLoader agentLoader){
        this.agentLoader=agentLoader;
    }

    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if(AgentTransformerWatch.getTransformerWatch().checkDelegate(className))
            return AgentTransformerWatch.getTransformerWatch().onStart(loader,className,classBeingRedefined,protectionDomain,classfileBuffer,agentLoader);
        else
            return classfileBuffer;
    }


}
