package br.com.achimid.puppeteerexecutor.gateway.input.http;

import br.com.achimid.puppeteerexecutor.domain.ExecutionRequest;
import br.com.achimid.puppeteerexecutor.gateway.output.rabbitmq.ExecutionProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ExecutionController {

    private final ExecutionProducer executionProducer;

    @PostMapping("/execution")
    @ResponseStatus(ACCEPTED)
    public void executionRequest(@RequestBody final ExecutionRequest request) {
        executionProducer.send(request);
    }

}
