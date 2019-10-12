package lljk.xtrace.boot;

import lljk.xtrace.traceOption.constant.AgentDelegateClassProfile;
import lljk.xtrace.traceUtil.propertiesUtil.PropertiesFactory;
import lljk.xtrace.traceUtil.propertiesUtil.PropertiesFileEnum;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.lang.reflect.Constructor;
import java.security.ProtectionDomain;
import java.util.Properties;

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
            return transform(loader,className,classBeingRedefined,protectionDomain,classfileBuffer,agentLoader);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer, ClassLoader agentClassLoader){

        return handle(loader,className,classBeingRedefined,protectionDomain,classfileBuffer,agentClassLoader);


    }


    public byte[] handle(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer, ClassLoader agentClassLoader) {
        byte[] originByte = classfileBuffer;
        try {
            PropertiesFactory propertiesFactory = new PropertiesFactory();
            Properties properties = propertiesFactory.getProperties(PropertiesFileEnum.CLASSVISITOR);
            String classVisitorClassName = properties.getProperty(className);
            ClassReader cr = new ClassReader(classfileBuffer);
            ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_MAXS);
            Class clazz =  this.getClass().getClassLoader().loadClass(classVisitorClassName);
            Constructor<?> cons = clazz.getConstructor(ClassVisitor.class);
            ClassVisitor findClassVisitor = (ClassVisitor)cons.newInstance(cw);
            cr.accept(findClassVisitor,0);
            return cw.toByteArray();
        }catch (Exception e){
            System.err.print("DefaultDispatcherTransform#transform异常"+e.getMessage());
            return originByte;
        }

    }
}
