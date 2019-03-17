package lljk.xtrace.traceUtil.propertiesUtil;

import java.io.IOException;
import java.util.Properties;

/**
 * @Description TODO
 * @Date 2019/3/17
 * @Author fangan
 **/
public class PropertiesFactory {


    public Properties getProperties(PropertiesFileEnum propertiesFileEnum){
        if(propertiesFileEnum== PropertiesFileEnum.CLASSVISITOR){

                Properties pps = new Properties();
                try {

                    pps.load(PropertiesFactory.class.getClassLoader().getResourceAsStream("delegateClassVisitor.properties"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return pps;


        }

        return  null;

    }
}
