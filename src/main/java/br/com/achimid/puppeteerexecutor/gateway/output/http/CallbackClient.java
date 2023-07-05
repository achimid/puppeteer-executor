package br.com.achimid.puppeteerexecutor.gateway.output.http;

import br.com.achimid.puppeteerexecutor.domain.Execution;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static io.micrometer.common.util.StringUtils.isEmpty;
import static org.springframework.http.HttpMethod.POST;

@Slf4j
@Component
@RequiredArgsConstructor
public class CallbackClient {

    private final RestTemplate restTemplate;

    public void send(@NonNull final Execution execution) {
        if (isEmpty(execution.getRequest().getCallbackUrl())) return;

        try {
            final var response = restTemplate.exchange(execution.getRequest().getUrl(), POST, new HttpEntity<Execution>(execution), Execution.class);
            log.info("Callback integration status: {}", response.getStatusCode());
        } catch (final Exception exception) {
            log.info("Callback error: {}", exception.getMessage());
        }
    }

}
