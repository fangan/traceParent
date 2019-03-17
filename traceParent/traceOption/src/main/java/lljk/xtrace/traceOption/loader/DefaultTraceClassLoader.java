package lljk.xtrace.traceOption.loader;


import lljk.xtrace.traceOption.agentClssProfile.AgentJarClass;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Description TODO
 * @Date 2019/3/15 下午6:13
 * @Author fangan
 **/
public class DefaultTraceClassLoader extends URLClassLoader {



    private final AgentJarClass agentJarClass;
    private final ClassLoader parent;

    public DefaultTraceClassLoader(URL[] urls, ClassLoader parent,AgentJarClass agentJarClass) {
        super(urls,parent);

        this.agentJarClass=agentJarClass;
        this.parent=parent;

    }



    static {
        if (!ClassLoader.registerAsParallelCapable()) {
            System.err.println("shit!");
        }
    }


    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class clazz = findLoadedClass(name);
            if (clazz == null) {
                if (agentJarClass.isAgentJarClass(name)) {
                    // load a class used for Pinpoint itself by this ClassLoader
                    clazz = findClass(name);
                } else {
                    try {
                        // load a class by parent ClassLoader
                        if (parent != null) {
                            clazz = parent.loadClass(name);
                        } else {
                            //c = findBootstrapClassOrNull(name);
                            //clazz = this.bootLoader.findBootstrapClassOrNull(this, name);
                        }
                    } catch (ClassNotFoundException ignore) {
                    }
                    if (clazz == null) {
                        // if not found, try to load a class by this ClassLoader
                        clazz = findClass(name);
                    }
                }
            }
            if (resolve) {
                resolveClass(clazz);
            }
            return clazz;
        }
    }


}
