package com.trbtree.service.modules.tree.entity;

import com.trbtree.service.modules.tree.enums.PostVisibility;
import com.trbtree.service.modules.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PostVisibility visibility = PostVisibility.PUBLIC;

    private Instant createdAt = Instant.now();
    private Instant updatedAt;
    private Instant deletedAt;

    private Integer likeCount = 0;
    private Integer commentCount = 0;
}