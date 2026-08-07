package com.trbtree.service.modules.tree.repository;

import com.trbtree.service.modules.tree.entity.PostComment;
import com.trbtree.service.modules.tree.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PostCommentRepository extends JpaRepository<PostComment, Integer> {

    List<PostComment> findByPostId(UUID postId);
}
