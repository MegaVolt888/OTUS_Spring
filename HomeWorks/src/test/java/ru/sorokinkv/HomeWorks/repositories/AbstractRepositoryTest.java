package ru.sorokinkv.HomeWorks.repositories;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;

@DataMongoTest
@EnableConfigurationProperties
@ComponentScan({"ru.sorokinkv.HomeWorks.config", "ru.sorokinkv.HomeWorks.repositories"})
public abstract class AbstractRepositoryTest {
}
