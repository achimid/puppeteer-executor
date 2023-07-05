package br.com.achimid.puppeteerexecutor.gateway.output.rabbitmq;

import br.com.achimid.puppeteerexecutor.domain.ExecutionRequest;
import br.com.achimid.puppeteerexecutor.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static br.com.achimid.puppeteerexecutor.config.RabbitmqConfig.EXECUTION_REQUEST_QUEUE;

@Component
@RequiredArgsConstructor
public class ExecutionProducer {

    @Qualifier(EXECUTION_REQUEST_QUEUE)
    private final Queue queue;
    private final JsonUtils jsonUtils;
    private final RabbitTemplate rabbitTemplate;

    public void send(final ExecutionRequest executionRequest) {
        rabbitTemplate.convertAndSend(this.queue.getName(), jsonUtils.toJson(executionRequest));
    }


}