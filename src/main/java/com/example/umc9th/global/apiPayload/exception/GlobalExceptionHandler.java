package com.example.umc9th.global.apiPayload.exception;

import com.example.umc9th.domain.review.exception.ReviewException;
import com.example.umc9th.domain.store.exception.StoreException;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralErrorCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ReviewException.class)
    public ApiResponse<?> handleReviewException(ReviewException e) {
        return ApiResponse.onFailure(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(StoreException.class)
    public ApiResponse<?> handleStoreException(StoreException e) {
        return ApiResponse.onFailure(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<?> handleGenericException(Exception e) {
    return ApiResponse.onFailure(GeneralErrorCode.BAD_REQUEST, e.getMessage());
    }
}
