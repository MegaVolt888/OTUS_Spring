package ru.sorokinkv.homework04.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import ru.sorokinkv.homework04.service.TestStudent;
import ru.sorokinkv.homework04.service.TestStudentImpl;

@Component
@ConfigurationProperties("main")
public class AppConfig {
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms
                = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Bean
    public TestStudent testService(MessageSource messageSource, LanguageConfig languageConfig) {
        return new TestStudentImpl(messageSource, languageConfig);
    }
}
