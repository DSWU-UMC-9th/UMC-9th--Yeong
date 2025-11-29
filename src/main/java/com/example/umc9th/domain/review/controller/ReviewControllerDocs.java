package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewRequest;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.dto.ReviewResponse;
import com.example.umc9th.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface ReviewControllerDocs {


    // 리뷰 추가
    @PostMapping
    ApiResponse<ReviewResponse> addReview(
            @RequestParam Long memberId,
            @RequestBody ReviewRequest request
    );

    @Operation(
            summary = "가게의 리뷰 목록 조회 API By 마크 (개발 중)",
            description = "특정 가게의 리뷰를 모두 조회합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })

    // 리뷰 목록 조회
    @GetMapping
    ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getReviews(
            @RequestParam String storeName,
            @RequestParam Integer page

    );

    // 검색 API
    @GetMapping("/search")
    ApiResponse<List<ReviewResponse>> searchReview(
            @RequestParam String query,
            @RequestParam String type
    );

    @Operation(
            summary = "내가 작성한 리뷰 목록 조회",
            description = "나의 리뷰를 모두 조회합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })

    // 1. 내가 작성한 리뷰 목록
    @GetMapping("/my")
    ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getMyReviews(
            @RequestParam Long memberId,// 필수요소
            @RequestParam Integer page,
            @RequestParam(required = false) Long storeId,
            @RequestParam(required = false) Float ratingGroup
    );

}
