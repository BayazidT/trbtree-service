package com.trbtree.service.modules.tree.entity;


import com.trbtree.service.modules.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "post_likes", schema = "trbtree")
@Getter
@Setter
public class PostLike {
    @Id
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(name = "is_liked", nullable = false)
//    @Builder.Default
    private boolean liked = true;

}
