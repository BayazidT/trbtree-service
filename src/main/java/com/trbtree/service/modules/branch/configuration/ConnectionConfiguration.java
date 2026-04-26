package com.trbtree.service.modules.branch.configuration;

import com.trbtree.service.modules.branch.mapper.UserConnectionMapper;
import com.trbtree.service.modules.branch.repository.ConnectionRepository;
import com.trbtree.service.modules.branch.service.ConnectionService;
import com.trbtree.service.modules.branch.service.impl.ConnectionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ConnectionConfiguration {
    private final ConnectionRepository connectionRepository;
    private final UserConnectionMapper userConnectionMapper;

    @Bean
    public ConnectionService connectionService() {
        return new ConnectionServiceImpl(connectionRepository, userConnectionMapper);
    }
}
