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
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Map;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class PagingJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job pagingTestJob(Step pagingTestStep) {
        return jobBuilderFactory.get("pagingTestJob")
                .start(pagingTestStep)
                .build();
    }

    @Bean
    public Step pagingTestStep(JdbcPagingItemReader<Shop> pagingTestReader) {
        return stepBuilderFactory.get("pagingTestStep")
                .<Shop, Shop>chunk(VsConstants.CHUNK_PAGE_SIZE)
                .reader(pagingTestReader)
                .writer(items -> {
                    for (Shop test : items)
                        log.info("pagingTestJob : {} - {}", test.getArticle(), test.getDealer());
                })
                .build();
    }


    @Bean
    public JdbcPagingItemReader<Shop> pagingTestReader(DataSource dataSource) throws Exception {
        JdbcPagingItemReader<Shop> reader = new JdbcPagingItemReaderBuilder<Shop>()
                .name("pagingTestReader")
                .dataSource(dataSource)
                .fetchSize(VsConstants.CHUNK_PAGE_SIZE)
                .rowMapper(ShopRowMapper.shopRowMapper)
                .queryProvider(getQueryProvider())
                .build();
        reader.afterPropertiesSet();
        return reader;
    }

    private PagingQueryProvider getQueryProvider() {
        MySqlPagingQueryProvider provider = new MySqlPagingQueryProvider();
        provider.setSelectClause("*");
        provider.setFromClause("shop");
        provider.setSortKeys(Map.of("article", Order.ASCENDING));
        return provider;
    }
}
