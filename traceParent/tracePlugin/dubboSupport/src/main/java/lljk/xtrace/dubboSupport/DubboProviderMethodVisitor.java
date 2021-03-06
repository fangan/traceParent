package lljk.xtrace.dubboSupport;

import lljk.xtrace.dubboSupport.inteceptor.DubboConsumerAfterInteceptor;
import lljk.xtrace.dubboSupport.inteceptor.DubboConsumerBeforeInteceptor;
import lljk.xtrace.dubboSupport.inteceptor.DubboProviderAfterInteceptor;
import lljk.xtrace.dubboSupport.inteceptor.DubboProviderBeforeInteceptor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import static org.objectweb.asm.Opcodes.*;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.RETURN;

/**
 * @Description TODO
 * @Date 2019/3/13 下午9:20
 * @Author fangan
 **/
public class DubboProviderMethodVisitor extends MethodVisitor {

    public DubboProviderMethodVisitor(int api, MethodVisitor methodVisitor) {
        super(api, methodVisitor);
    }

    //AbstractClusterInvoker
    //AbstractProxyInvoker

    @Override
    public void visitCode() {

        mv.visitVarInsn(Opcodes.ALOAD,1);
        mv.visitMethodInsn(INVOKESTATIC, DubboProviderBeforeInteceptor.class.getName().replace(".","/"),"before","(Lcom/alibaba/dubbo/rpc/Invocation;)V",false);

        super.visitCode();
    }

    @Override
    public void visitInsn(int opcode) {

        if(opcode == LRETURN ||
                opcode == DRETURN ||
                opcode == FRETURN ||
                opcode == IRETURN ||
                opcode == ARETURN ||
                opcode == RETURN ) {

            mv.visitMethodInsn(INVOKESTATIC, DubboProviderAfterInteceptor.class.getName().replace(".","/"),"after","()V",false);

        }
        super.visitInsn(opcode);


    }
}
