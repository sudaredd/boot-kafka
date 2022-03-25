package app.message.bootkafka.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
public class PropertiesConfiguration {

  @Bean
  public PropertySourcesPlaceholderConfigurer properties() {
    PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
//    ppc.setIgnoreResourceNotFound(true);
    final List<Resource> resources = new ArrayList<>();
    resources.add(new ClassPathResource("bts.properties"));
    resources.add(new ClassPathResource("bhats_ps.properties"));
    ppc.setLocations(resources.toArray(new Resource[] {}));
    return ppc;
  }
}
