package ru.sorokinkv.spring.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@NoArgsConstructor
public class LanguageConfig {
    @Value("#{ systemProperties['user.language']}")
    private String language;
    @Value("#{ systemProperties['user.country']}")
    private String country;

}
