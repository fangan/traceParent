package lljk.xtrace.dubboSupport;

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




//        mv.visitVarInsn(Opcodes.ALOAD,0);
//        mv.visitFieldInsn(GETFIELD, "com/mysql/jdbc/PreparedStatement", "originalSql", "Ljava/lang/String;");
//        mv.visitMethodInsn(INVOKESTATIC, Paratest.class.getName().replace(".","/"),"say","(Ljava/lang/String;)V",false);
//
//
//        mv.visitMethodInsn(INVOKESTATIC, LanjieTest.class.getName().replace(".","/"),"beforeMethod","()V",false);
        super.visitCode();
    }

    @Override
    public void visitInsn(int opcode) {
//        if(opcode == LRETURN ||
//                opcode == DRETURN ||
//                opcode == FRETURN ||
//                opcode == IRETURN ||
//                opcode == ARETURN ||
//                opcode == RETURN ) {
//            mv.visitMethodInsn(INVOKESTATIC, LanjieTest.class.getName().replace(".","/"),"afterMethod","()V",false);
//        }
        super.visitInsn(opcode);
    }
}
