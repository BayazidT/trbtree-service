// src/main/java/com/tr/rms/rbac/repository/RoleRepository.java
package com.trbtree.service.rbac.repository;

import com.trbtree.service.rbac.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {

    @Query("SELECT r FROM Role r JOIN r.userRoles ur WHERE ur.user.id = :userId ")
    Set<Role> findActiveByUserId(@Param("userId") UUID userId);

    @Query("select r from Role r where r.id = :roleId")
    Role findRoleById(UUID roleId);
}