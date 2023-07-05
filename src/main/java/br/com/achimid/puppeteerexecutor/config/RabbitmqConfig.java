package br.com.achimid.puppeteerexecutor.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    public static final String EXECUTION_REQUEST_QUEUE = "WORKER_EXECUTION_REQUEST";
    public static final String EXECUTION_RESPONSE_QUEUE = "WORKER_EXECUTION_RESPONSE";

    @Bean(EXECUTION_REQUEST_QUEUE)
    public Queue queueExecutionRequest() {
        return new Queue(EXECUTION_REQUEST_QUEUE, true);
    }



}