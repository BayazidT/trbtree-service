package com.trbtree.service.modules.tree.configuration;

import com.trbtree.service.modules.tree.mapper.PostMapper;
import com.trbtree.service.modules.tree.repository.PostRepository;
import com.trbtree.service.modules.tree.service.PostService;
import com.trbtree.service.modules.tree.service.impl.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PostConfiguration {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Bean
    public PostService postService() {
        return new PostServiceImpl(postRepository, postMapper);
    }
}
