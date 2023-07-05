package br.com.achimid.puppeteerexecutor.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ExecutionResponse {

    private UUID uuid;
    private Object result;
    private boolean isSuccess;
    private String executionTime;
    private LocalDateTime endTime;
    private LocalDateTime startTime;

}
