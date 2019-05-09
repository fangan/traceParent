package lljk.xtrace.traceFlush;

import lljk.xtrace.traceFlush.kafka.TraceKafkaProducer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @Description TODO
 * @Date 2019/5/8
 * @Author fangan
 **/
public class DefaultTraceLogWrite implements TraceLogWrite{

    public void write(TraceLog traceLog) {

        Producer<String,TraceLog> producer = TraceKafkaProducer.getKafkaProducer();

        producer.send(new ProducerRecord<String, TraceLog>("x-trace-log", traceLog.getTraceId(), traceLog));

    }
}
