package com.trbtree.service.modules.user.controller;

import com.trbtree.service.modules.user.dto.UserListResponse;
import com.trbtree.service.modules.user.service.UserTreeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trbtree-service/api/v1/private/users/tree")
public class UserTreeController {

    private final UserTreeService userTreeService;

    @GetMapping("/{userId}")
    public UserListResponse getUserTree(@PathVariable UUID userId,
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "10") int size
    ) {
        return userTreeService.getUserTree(userId,page,size);
    }

}
