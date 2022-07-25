package com.osori.applicationbatch.job.cursorvspaging;

import com.osori.applicationbatch.job.cursorvspaging.constants.ShopRowMapper;
import com.osori.applicationbatch.job.cursorvspaging.constants.VsConstants;
import com.osori.applicationbatch.job.cursorvspaging.domain.Shop;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CursorJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final DataSource dataSource;

    @Bean
    public Job cursorTestJob(Step cursorTestStep) {
        return jobBuilderFactory.get("cursorTestJob")
                .start(cursorTestStep)
                .build();
    }

    @Bean
    public Step cursorTestStep(JdbcCursorItemReader<Shop> reader) {
        return stepBuilderFactory.get("cursorTestStep")
                .<Shop, Shop>chunk(VsConstants.CHUNK_PAGE_SIZE)
                .reader(reader)
                .writer(items -> {
                    for (Shop test : items)
                        log.info("cursorTestJob : {} - {}", test.getArticle(), test.getDealer());
                })
                .build();
    }


    @Bean
    public JdbcCursorItemReader<Shop> reader() throws Exception {
        JdbcCursorItemReader<Shop> reader = new JdbcCursorItemReaderBuilder<Shop>()
                .name("cursorTestReader")
                .fetchSize(VsConstants.CHUNK_PAGE_SIZE)
                .verifyCursorPosition(false)
                .rowMapper(ShopRowMapper.shopRowMapper)
                .sql("SELECT * FROM shop")
                .dataSource(dataSource)
                .build();
        reader.afterPropertiesSet();
        return reader;
    }
}

