package lljk.xtrace.boot;

import lljk.xtrace.traceOption.constant.AgentDelegateClassProfile;

import java.lang.reflect.Method;
import java.security.ProtectionDomain;

/**
 * @Description TODO
 * @Date 2019/3/17
 * @Author fangan
 **/
public class AgentTransformerWatch {
    private static AgentTransformerWatch agentTransformerWatch;

    private AgentTransformerWatch(){

    }
    public static AgentTransformerWatch getTransformerWatch(){
        if(agentTransformerWatch != null){
            return agentTransformerWatch;
        }else{
            synchronized (AgentTransformerWatch.class){
                if(agentTransformerWatch != null){
                    return agentTransformerWatch;
                }else{
                    return new AgentTransformerWatch();

                }
            }
        }
    }

    public boolean checkDelegate(String name){
        if (AgentDelegateClassProfile.TRACE_DELEGATE_CLASS.contains(name)){
            return true;
        }
        return false;
    }

    public byte[] onStart(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer,ClassLoader agentLoader){
        try {
            Class clazz =  agentLoader.loadClass("lljk.xtrace.boot.AgentStart");
            Object o = clazz.newInstance();
            Method method = clazz.getMethod("transform",ClassLoader.class, String.class, Class.class, ProtectionDomain.class, byte[].class ,ClassLoader.class);
            return (byte[])method.invoke(o,loader,className,classBeingRedefined,protectionDomain,classfileBuffer,agentLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
