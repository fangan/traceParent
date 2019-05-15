package lljk.xtrace.dubboSupport;

import lljk.xtrace.traceOption.constant.AsmVersion;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @Description TODO
 * @Date 2019/3/14 下午2:02
 * @Author fangan
 **/
public class DubboProviderClassVisitor extends ClassVisitor{


    public DubboProviderClassVisitor(ClassVisitor cv) {
        super(AsmVersion.ASM_VERSION, cv);
    }

    public DubboProviderClassVisitor(int i, ClassVisitor classVisitor) {
        super(i, classVisitor);
    }


    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {

            if(name.equals("invoke") && descriptor.equals("(Lcom/alibaba/dubbo/rpc/Invocation;)Lcom/alibaba/dubbo/rpc/Result;")){
                MethodVisitor mv = cv.visitMethod(access, name, descriptor, signature, exceptions);
                return new DubboProviderMethodVisitor(this.api,mv);
            }
        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }
}
