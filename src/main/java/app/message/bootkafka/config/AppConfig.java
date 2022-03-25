package app.message.bootkafka.config;

import app.message.bootkafka.KafkaProperties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ContainerProperties;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {

  @Bean("appKafkaListenerContainerFactory")
  public ConcurrentKafkaListenerContainerFactory<byte[], byte[]> kafkaListenerFactory(
      KafkaProperties properties) {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getKafkaAppAddress());
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class);
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
    props.put(ConsumerConfig.GROUP_ID_CONFIG, properties.getKafkaConsumerGroup());
    var consumerFactory = new DefaultKafkaConsumerFactory<byte[], byte[]>(props);
    var containerFactory = new ConcurrentKafkaListenerContainerFactory<byte[], byte[]>();
    containerFactory.setConsumerFactory(consumerFactory);
    containerFactory.getContainerProperties().setAckMode(ContainerProperties.AckMode.RECORD);
    return containerFactory;
  }

  @Bean
  public KafkaTemplate<String, String> kafkaAppTemplate(KafkaProperties properties) {
    Map<String, Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getKafkaAppAddress());
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    var producerFactory = new DefaultKafkaProducerFactory<String, String>(props);
    return new KafkaTemplate<>(producerFactory);
  }
}
