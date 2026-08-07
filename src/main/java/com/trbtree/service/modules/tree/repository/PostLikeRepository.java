package com.trbtree.service.modules.tree.repository;

import com.trbtree.service.modules.tree.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface PostLikeRepository extends JpaRepository<PostLike, Integer> {

    @Query("""
SELECT pl from PostLike pl where (pl.id=:id and pl.user.id=:userId)
""")
    PostLike findByIdAndUserId(UUID id, UUID userId);

    @Query("""
SELECT pl from PostLike pl where (pl.post.id=:id and pl.user.id=:userId)
""")
    PostLike findByPostIdAndUserId(UUID id, UUID userId);
}
