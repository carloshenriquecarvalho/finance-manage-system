package br.com.nexus.finance_manage_system.exception;

import java.time.OffsetDateTime;

public record ErrorResponse(
        Integer status,
        String error,
        String message,
        OffsetDateTime timestamp
) {
}
