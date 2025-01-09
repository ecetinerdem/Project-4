package com.workintech.s19d1.exceptions;

import java.time.LocalDateTime;

public record ActorErrorResponse(Integer status, String Message, LocalDateTime localDateTime) {
}
