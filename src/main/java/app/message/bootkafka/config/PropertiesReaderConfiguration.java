package app.message.bootkafka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
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
