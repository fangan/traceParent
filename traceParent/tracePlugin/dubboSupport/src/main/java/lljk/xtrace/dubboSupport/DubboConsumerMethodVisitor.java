package lljk.xtrace.dubboSupport;

import lljk.xtrace.dubboSupport.inteceptor.DubboConsumerAfterInteceptor;
import lljk.xtrace.dubboSupport.inteceptor.DubboConsumerBeforeInteceptor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import static org.objectweb.asm.Opcodes.*;


/**
 * @Description TODO
 * @Date 2019/3/13 下午9:20
 * @Author fangan
 **/
public class DubboConsumerMethodVisitor extends MethodVisitor {

    public DubboConsumerMethodVisitor(int api, MethodVisitor methodVisitor) {
        super(api, methodVisitor);
    }

    //AbstractClusterInvoker
    //AbstractProxyInvoker a

    @Override
    public void visitCode() {

        mv.visitVarInsn(Opcodes.ALOAD,0);
        mv.visitVarInsn(Opcodes.ALOAD,1);
        mv.visitMethodInsn(INVOKESTATIC, DubboConsumerBeforeInteceptor.class.getName().replace(".","/"),"before","(Lcom/alibaba/dubbo/rpc/Invoker;Lcom/alibaba/dubbo/rpc/Invocation;)V",false);

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

            //mv.visitVarInsn(Opcodes.ASTORE,3);
            //mv.visitVarInsn(Opcodes.ALOAD,3);
            mv.visitMethodInsn(INVOKESTATIC, DubboConsumerAfterInteceptor.class.getName().replace(".","/"),"after","()V",false);
            //mv.visitVarInsn(Opcodes.ALOAD,3);

        }
        super.visitInsn(opcode);
    }
}
