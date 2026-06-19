package com.trbtree.service.modules.tree.repository;

import com.trbtree.service.modules.tree.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findByUserId(UUID userId);

    List<Post> findAllByOrderByCreatedAtDesc();
}
