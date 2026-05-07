package com.trbtree.service.modules.tree.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PostListResponse {
    private List<PostResponse> content;
    long totalElements;
    int totalPages;
    int pageNumber;
    int pageSize;
    boolean first;
    boolean last;
}
