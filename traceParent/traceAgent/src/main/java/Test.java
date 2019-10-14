import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.cluster.Directory;
import com.alibaba.dubbo.rpc.cluster.LoadBalance;
import com.alibaba.dubbo.rpc.cluster.support.AbstractClusterInvoker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2019/3/13 下午9:02
 * @Author fangan
 **/
public class Test {
    public static void say(){
        System.out.println("abc");
    }
    public static void main(String[] args) {
        ClassLoader loader = AbstractClusterInvoker.class.getClassLoader();
        AbstractClusterInvoker a = null;
//com.alibaba.dubbo.rpc.cluster.support.AbstractClusterInvoker
        Directory directory = new Directory() {
            @Override
            public Class getInterface() {
                return null;
            }

            @Override
            public List<Invoker> list(Invocation invocation) throws RpcException {
                return null;
            }

            @Override
            public com.alibaba.dubbo.common.URL getUrl() {
                return null;
            }

            @Override
            public boolean isAvailable() {
                return false;
            }

            @Override
            public void destroy() {

            }
        };
        URL url = new URL("AA","BB",1);
        a = new AbstractClusterInvoker(directory,url) {
            @Override
            protected Result doInvoke(Invocation invocation, List list, LoadBalance loadBalance) throws RpcException {
                return null;
            }
        };
        a.invoke(new Invocation() {
            @Override
            public String getMethodName() {
                return null;
            }

            @Override
            public Class<?>[] getParameterTypes() {
                return new Class[0];
            }

            @Override
            public Object[] getArguments() {
                return new Object[0];
            }

            @Override
            public Map<String, String> getAttachments() {
                Map<String, String> attachment = new HashMap<>();
                attachment.put("a","bbb");
                return attachment;


            }

            @Override
            public String getAttachment(String s) {
                return null;
            }

            @Override
            public String getAttachment(String s, String s1) {

                return null;
            }

            @Override
            public Invoker<?> getInvoker() {
                return null;
            }
        });

        System.out.println(a==null);

    }
}
