package com.trbtree.service.modules.user.specification;

import com.trbtree.service.modules.user.entity.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {
    public static Specification<User> searchLike(String keyword) {
        return (root, query, cb) -> {
            if (keyword == null || keyword.isBlank()) {
                return null;
            }

            String pattern = "%" + keyword.toLowerCase() + "%";

            return cb.or(
                    cb.like(cb.lower(root.get("user").get("name")), pattern),
                    cb.like(cb.lower(root.get("user").get("email")), pattern)
            );
        };
    }
}
