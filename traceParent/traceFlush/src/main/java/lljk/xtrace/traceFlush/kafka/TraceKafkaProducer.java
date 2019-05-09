package lljk.xtrace.traceFlush.kafka;

import lljk.xtrace.traceFlush.TraceLog;
import org.apache.kafka.clients.producer.Producer;

import java.io.IOException;
import java.util.Properties;

/**
 * @Description TODO
 * @Date 2019/5/9
 * @Author fangan
 **/
public class TraceKafkaProducer {
    private static Producer<String,TraceLog> producer;
    public static Producer<String,TraceLog> getKafkaProducer(){
        if(producer != null){
            return producer;
        }
        synchronized (TraceKafkaProducer.class){
            if(producer != null){
                return producer;
            }
            Properties pps = new Properties();
            try {

                pps.load(TraceKafkaProducer.class.getClassLoader().getResourceAsStream("kafka.properties"));

                producer = new org.apache.kafka.clients.producer.KafkaProducer<String,TraceLog>(pps);
                return producer;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;

        }
    }
}
