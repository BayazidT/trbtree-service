package com.trbtree.service.modules.branch.dto;

import com.trbtree.service.modules.branch.enums.ConnectionStatus;
import lombok.Data;

@Data
public class ConnectionUpdateRequest {
    ConnectionStatus status;
}
