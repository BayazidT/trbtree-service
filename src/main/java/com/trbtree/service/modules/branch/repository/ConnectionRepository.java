package com.trbtree.service.modules.branch.repository;

import com.trbtree.service.modules.branch.entity.UserConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ConnectionRepository extends JpaRepository<UserConnection, UUID> {

    @Query("""
            SELECT uc
                FROM UserConnection uc
                WHERE (uc.addressee.id = :userId)
                   AND uc.status = 'PENDING'
""")
    List<UserConnection> findByAddresseeId(UUID userId);

    @Query("""
            SELECT uc
                FROM UserConnection uc
                WHERE (uc.requester.id = :userId)
                   AND uc.status = 'PENDING'
""")
    List<UserConnection> findByRequesterId(UUID userId);

    @Query("""
    SELECT uc
    FROM UserConnection uc
    WHERE (uc.requester.id = :userId
       OR uc.addressee.id = :userId)
       AND uc.status = 'ACCEPTED'
""")
    List<UserConnection> findAllConnections(@Param("userId") UUID userId);

    @Query("""
    SELECT uc
    FROM UserConnection uc
    WHERE (uc.requester.id = :userId
       OR uc.addressee.id = :userId)
""")
    List<UserConnection> findUserTreeExcept(@Param("userId") UUID userId);
}
