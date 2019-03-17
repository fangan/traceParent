package lljk.xtrace.dubboSupport.inteceptor;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.dubbo.rpc.Invocation;

import java.util.Map;

/**
 * @Description TODO
 * @Date 2019/3/14 下午1:07
 * @Author fangan
 **/
public class DubboConsumerBeforeInteceptor {
    public static void before(Object param){
        System.out.println("before");
        Invocation invocation = (Invocation) param;
        Object[] argument = invocation.getArguments();
        Class<?>[] parameterType = invocation.getParameterTypes();
        Map<String, String> attachment =  invocation.getAttachments();
        String methodName = invocation.getMethodName();
        //Class anInterface = invocation.getInvoker().getInterface();
        System.out.println(JSONObject.toJSON(argument));
        for(Class p:parameterType){
            System.out.println(p);
        }
        System.out.println(JSONObject.toJSON(attachment));
        System.out.println(JSONObject.toJSON(methodName));



    }
}
