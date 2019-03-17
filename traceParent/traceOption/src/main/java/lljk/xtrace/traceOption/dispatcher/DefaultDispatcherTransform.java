package lljk.xtrace.traceOption.dispatcher;

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
public class DefaultDispatcherTransform implements DispatcherTransform{

    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer, ClassLoader agentClassLoader) {
        byte[] originByte = classfileBuffer;
        try {
            PropertiesFactory propertiesFactory = new PropertiesFactory();
            Properties properties = propertiesFactory.getProperties(PropertiesFileEnum.CLASSVISITOR);

            String classVisitorClassName = properties.getProperty(className);

            ClassReader cr = new ClassReader(classfileBuffer);

            ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_MAXS);

            Class classVisitor =  this.getClass().getClassLoader().loadClass(classVisitorClassName);

            Constructor<?> cons = classVisitor.getConstructor(ClassVisitor.class);
            ClassVisitor findClassVisitor = (ClassVisitor)cons.newInstance(cw);

            cr.accept(findClassVisitor,0);
            return cw.toByteArray();
        }catch (Exception e){
            return originByte;
        }

    }
}
