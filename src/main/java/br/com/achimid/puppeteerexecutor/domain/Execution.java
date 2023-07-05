package br.com.achimid.puppeteerexecutor.domain;

import lombok.Data;

@Data
public class Execution {

    private ExecutionRequest request;
    private ExecutionResponse response;

}
