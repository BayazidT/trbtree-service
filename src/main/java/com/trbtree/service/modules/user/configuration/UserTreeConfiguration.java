package com.trbtree.service.modules.user.configuration;

import com.trbtree.service.modules.branch.repository.ConnectionRepository;
import com.trbtree.service.modules.user.mapper.UserMapper;
import com.trbtree.service.modules.user.repository.UserRepository;
import com.trbtree.service.modules.user.service.UserTreeService;
import com.trbtree.service.modules.user.service.impl.UserTreeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UserTreeConfiguration {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ConnectionRepository connectionRepository;

   @Bean
    public UserTreeService userTreeService() {
       return new UserTreeServiceImpl(userRepository, userMapper, connectionRepository);
   }
}
