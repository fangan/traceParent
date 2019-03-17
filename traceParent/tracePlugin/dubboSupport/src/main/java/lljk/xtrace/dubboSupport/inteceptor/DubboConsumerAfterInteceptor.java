package lljk.xtrace.dubboSupport.inteceptor;

import com.alibaba.dubbo.rpc.Result;
import com.alibaba.fastjson.JSONObject;

/**
 * @Description TODO
 * @Date 2019/3/14 下午1:07
 * @Author fangan
 **/
public class DubboConsumerAfterInteceptor {
    public static void after(Object o){
        Result result = (Result)o;
        System.out.println(22);
        System.out.println(JSONObject.toJSONString(result));
        System.out.println(11);
        //System.out.println(JSONObject.class.getClassLoader());
//        System.out.println("after");
//        System.out.println(o.toString());
//        System.out.println("after");
    }
}
