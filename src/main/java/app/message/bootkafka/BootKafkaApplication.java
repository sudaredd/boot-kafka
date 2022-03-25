package app.message.bootkafka;

import app.message.bootkafka.model.Bean1;
import app.message.bootkafka.model.Bean2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@EnableConfigurationProperties({KafkaProperties.class})
@SpringBootApplication
public class BootKafkaApplication {
  @Slf4j
  @Component
  private static class PropReaderService implements CommandLineRunner {
    @Autowired
    private Map<String, String> map;

    @Value("${app.boot.kafka-consumer-group}")
    private String group;

    @Autowired
    private Bean1 bean1;

    @Autowired
    private Bean2 bean2;

    @Override
    public void run(String... args) throws Exception {
      log.info("properties frome xternal file {}", map);

      log.info("properties frome app file {}", group);

      log.info("values from beans fileds {} and {} ", bean1.getField1(), bean2.getField2());
    }
  }
  public static void main(String[] args) {
    SpringApplication.run(BootKafkaApplication.class, args);
  }
}
