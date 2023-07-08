package br.com.achimid.puppeteerexecutor.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class ExecutionRequest {

    private UUID id = UUID.randomUUID();
    private String ref;
    private String url;
    private String script;
    private String callbackUrl;
    private ExecutionRequest config;

    @Data
    public class ExecutionRequestConfig {

        private Boolean bypassCSP;
        private Boolean useRandomAgent;
        private Boolean skipImage;
        private Boolean logConsole;
        private String waitTime;
        private String urlProxy;
        private String defaultNavigationTimeout;
        private String addScriptTagUrl;

    }

}
