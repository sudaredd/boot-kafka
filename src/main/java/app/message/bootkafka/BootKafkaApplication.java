package app.message.bootkafka;

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

    @Override
    public void run(String... args) throws Exception {
      log.info("properties frome xternal file {}", map);

      log.info("properties frome app file {}", group);
    }
  }
  public static void main(String[] args) {
    SpringApplication.run(BootKafkaApplication.class, args);
  }
}
