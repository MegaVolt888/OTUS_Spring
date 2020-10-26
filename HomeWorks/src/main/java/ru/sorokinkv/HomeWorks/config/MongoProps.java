package ru.sorokinkv.HomeWorks.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("spring.data.mongodb")
public class MongoProps {
    private String uri;
    private int port;
    private String database;
}
