package com.trbtree.service.modules.user.entity;

import com.trbtree.service.rbac.entity.Role;
import com.trbtree.service.rbac.entity.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "users", schema = "trbtree")
@Where(clause = "is_active = true")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"roles", "password"})
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true, length = 40)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 100)
    private String displayName;       // renamed from 'name' for clarity

    @Column(length = 500)
    private String bio;

    private String profile_picture_url;

    private String location;

    @Column(name = "website_url")
    private String website;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private boolean active = true;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            schema = "trbtree",                    // ← consistent schema
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @Builder.Default
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserRole> userRoles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();

        // 1. Add roles with ROLE_ prefix (Spring convention)
        roles.forEach(role ->
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()))
        );

        // 2. Add individual permissions (uncommented & fixed)
//        roles.stream()
//                .flatMap(role -> role.getRolePermissions().stream())
//                .map(rp -> rp.getPermission())
//                .map(perm -> new SimpleGrantedAuthority(perm.getName()))   // e.g. "post:delete:any"
//                .forEach(authorities::add);

        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}