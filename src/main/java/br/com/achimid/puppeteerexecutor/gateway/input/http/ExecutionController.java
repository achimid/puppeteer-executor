package br.com.achimid.puppeteerexecutor.gateway.input.http;

import br.com.achimid.puppeteerexecutor.domain.Execution;
import br.com.achimid.puppeteerexecutor.domain.ExecutionRequest;
import br.com.achimid.puppeteerexecutor.gateway.output.rabbitmq.ExecutionProducer;
import br.com.achimid.puppeteerexecutor.gateway.output.repository.memory.ExecutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class ExecutionController {

    private final ExecutionProducer executionProducer;
    private final ExecutionRepository executionRepository;

    @ResponseStatus(ACCEPTED)
    @PostMapping("/execution")
    public ExecutionRequest executionRequest(@RequestBody final ExecutionRequest request) {
        executionProducer.send(request);
        return request;
    }

    @ResponseStatus(OK)
    @GetMapping("/execution/{id}")
    public Execution getExecutionResponse(@PathVariable("id") final String id) {
        return executionRepository.findById(UUID.fromString(id));
    }


}
