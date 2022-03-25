package app.message.bootkafka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySources({
  @PropertySource("classpath:bts.properties"),
  @PropertySource(value = "classpath:bhats_pskkk.properties", ignoreResourceNotFound = true),
  @PropertySource("classpath:bhats_ps.properties")
})
@ImportResource({ "classpath:beans1.xml", "classpath:beans2.xml" })
public class PropertiesReaderConfiguration {

  @Value("${ps}")
  private String isPs;

  @Value("${ts}")
  private String isTs;

  @Bean
  Map<String, String> map() {
    Map<String, String> map = new HashMap<>();

    map.put("ps", isPs);
    map.put("ts", isTs);
    return map;
  }
}
