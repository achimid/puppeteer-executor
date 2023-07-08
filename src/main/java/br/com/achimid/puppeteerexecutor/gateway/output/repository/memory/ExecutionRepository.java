package br.com.achimid.puppeteerexecutor.gateway.output.repository.memory;

import br.com.achimid.puppeteerexecutor.domain.Execution;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class ExecutionRepository {

    final Map<UUID, Execution> DB = new HashMap<>();

    public Execution findById(final UUID id) {
        return DB.remove(id);
    }

    public void insert(final Execution execution) {
        DB.put(execution.getRequest().getId(), execution);
    }
}
