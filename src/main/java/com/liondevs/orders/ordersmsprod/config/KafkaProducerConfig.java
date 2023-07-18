package com.liondevs.orders.ordersmsprod.config;



import com.liondevs.orders.ordersmsprod.event.Event;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaProducerConfig {


    public Map<String, Object> senderProps() {
        String bootstrapAddress = "pkc-p11xm.us-east-1.aws.confluent.cloud:9092";
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        props.put(JsonSerializer.TYPE_MAPPINGS,"com.liondevs:com.liondevs.orders.ordersmsprod.event.OrderCreatedEvent");

        //...
        return props;
    }

    @Bean
    public ProducerFactory<String, Event<?>> producerFactory() {
        return new DefaultKafkaProducerFactory<>(senderProps());
    }

    @Bean
    public KafkaTemplate<String, Event<?>> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
