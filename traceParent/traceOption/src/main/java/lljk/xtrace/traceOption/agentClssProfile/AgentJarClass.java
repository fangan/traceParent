package lljk.xtrace.traceOption.agentClssProfile;

public interface AgentJarClass {
    boolean IS_LOAD_CLASS = true;
    boolean NOT_LOAD_CLASS = false;

    boolean isAgentJarClass(String className);
}
