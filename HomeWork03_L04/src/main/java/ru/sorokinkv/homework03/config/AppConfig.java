package ru.sorokinkv.homework03.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.sorokinkv.homework03.service.TestStudent;
import ru.sorokinkv.homework03.service.TestStudentImpl;

@Configuration
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
