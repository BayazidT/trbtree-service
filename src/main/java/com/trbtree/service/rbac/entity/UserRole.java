// src/main/java/com/tr/rms/rbac/entity/UserRole.java
package com.trbtree.service.rbac.entity;

import com.trbtree.service.modules.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Table(name = "user_roles", schema = "infotree")
@Getter
@Setter
@NoArgsConstructor
public class UserRole {

    @EmbeddedId
    private UserRoleId id = new UserRoleId();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(name = "assigned_at")
    private LocalDateTime assignedAt = LocalDateTime.now();

    // Optional constructor
    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
        this.id = new UserRoleId(user.getId(), role.getId());
    }
}