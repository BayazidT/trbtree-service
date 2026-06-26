package com.trbtree.service.modules.tree.configuration;

import com.trbtree.service.modules.tree.mapper.PostCommentMapper;
import com.trbtree.service.modules.tree.repository.PostCommentRepository;
import com.trbtree.service.modules.tree.repository.PostRepository;
import com.trbtree.service.modules.tree.service.PostCommentService;
import com.trbtree.service.modules.tree.service.impl.PostCommentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PostCommentConfiguration {
    private final PostCommentRepository repository;
    private final PostCommentMapper postCommentMapper;
    private final PostRepository postRepository;

    @Bean
    public PostCommentService postCommentService() {
        return new PostCommentServiceImpl(repository, postCommentMapper, postRepository);
    }
}
