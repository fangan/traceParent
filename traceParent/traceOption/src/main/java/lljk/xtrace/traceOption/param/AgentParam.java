package lljk.xtrace.traceOption.param;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description TODO
 * @Date 2019/3/22
 * @Author fangan
 **/
public class AgentParam extends AgentJvmParam {



    public URL[] getAgentUrls() {
        String path = findTraceAgentPath();
        try {
            URL url = new URL("file:"+path);
            return  new URL[]{url};
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
