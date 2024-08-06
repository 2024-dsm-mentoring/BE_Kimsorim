package com.example.mentoring.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ExceptionCustom extends RuntimeException{
    private final String errorCode;
    private final String errorMessage;

}
