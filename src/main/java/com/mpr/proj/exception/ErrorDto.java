package com.mpr.proj.exception;

import java.time.Instant;

public record ErrorDto(String message, Instant time) {

}
