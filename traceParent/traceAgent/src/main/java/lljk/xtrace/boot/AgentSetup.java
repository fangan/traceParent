package lljk.xtrace.boot;

import lljk.xtrace.traceContext.TraceContextHandle;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

/**
 * @Description TODO
 * @Date 2019/5/7
 * @Author fangan
 **/
public class AgentSetup {
    public void setup(Instrumentation instrumentation){

        ClassFileTransformer trans =  new TraceClassFileTransformer(this.getClass().getClassLoader());
        instrumentation.addTransformer(trans);

    }
}
