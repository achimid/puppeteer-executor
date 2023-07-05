package br.com.achimid.puppeteerexecutor.gateway.input.rabbitmq;

import br.com.achimid.puppeteerexecutor.domain.Execution;
import br.com.achimid.puppeteerexecutor.domain.ExecutionResponse;
import br.com.achimid.puppeteerexecutor.gateway.output.http.CallbackClient;
import br.com.achimid.puppeteerexecutor.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static br.com.achimid.puppeteerexecutor.config.RabbitmqConfig.EXECUTION_RESPONSE_QUEUE;


@Slf4j
@Component
@RequiredArgsConstructor
public class ExecutionConsumer {

    private final JsonUtils jsonUtils;
    private final CallbackClient callbackClient;

    @RabbitListener(queues = EXECUTION_RESPONSE_QUEUE)
    public void receive(@Payload String executionJson) {
        log.info("Execution Response: {}", executionJson);
        callbackClient.send(jsonUtils.toObject(executionJson, Execution.class));
    }

}