package ru.sorokinkv.homework03.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "locale")
@Data
public class LanguageConfig {
    private String languageTag;
}
