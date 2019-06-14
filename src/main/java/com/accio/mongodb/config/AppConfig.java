package com.accio.mongodb.config;
/**
 * @author Esh
 */
import com.accio.mongodb.utilities.uuid_gen.RequestListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.servlet.ServletRequestListener;
import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AppConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class.getSimpleName());

    /**
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean<ServletRequestListener> listenerRegistrationBean() {
        ServletListenerRegistrationBean<ServletRequestListener> bean = new ServletListenerRegistrationBean<>();
        bean.setListener(new RequestListener());
        return bean;
    }

    /**
     * @return
     */
    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(8);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("tpe-");
        executor.initialize();
        return executor;
    }

}
