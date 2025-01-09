package com.workintech.s19d1.exceptions;

import java.time.LocalDateTime;

public record MovieErrorResponse(Integer status, String message, LocalDateTime localDateTime) {
}
