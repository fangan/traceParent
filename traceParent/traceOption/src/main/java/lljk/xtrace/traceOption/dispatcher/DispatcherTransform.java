package lljk.xtrace.traceOption.dispatcher;

import java.security.ProtectionDomain;

public interface DispatcherTransform {
    byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer, ClassLoader agentClassLoader);

}
