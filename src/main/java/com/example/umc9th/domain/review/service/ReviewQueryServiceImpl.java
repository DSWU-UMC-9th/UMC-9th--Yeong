package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.location.entity.QLocation;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.exception.MemberException;
import com.example.umc9th.domain.member.exception.code.MemberErrorCode;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.exception.ReviewException;
import com.example.umc9th.domain.review.exception.code.ReviewErrorCode;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.exception.StoreException;
import com.example.umc9th.domain.store.exception.code.StoreErrorCode;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;


    @Override
    public List<Review> searchReview(String query, String type) {

        QReview review = QReview.review;
        QLocation location = QLocation.location;

        BooleanBuilder builder = new BooleanBuilder();

        if(type.equals("location")){
            builder.and(location.name.contains(query));
        }
        if(type.equals("score")){
            builder.and(review.score.goe(Float.parseFloat(query)));
        }
        if(type.equals("both")){
            String firstQuery = query.split("&")[0];
            String secondQuery = query.split("&")[1];

            builder.and(location.name.contains(firstQuery));
            builder.and(review.score.goe(Float.parseFloat(secondQuery)));
        }

        return reviewRepository.searchReview(builder);
    }

    @Override
    public ReviewResDTO.ReviewPreViewListDTO findReview(
            String storeName,
            Integer page
    ){
        // - 가게를 가져온다 (가게 존재 여부 검증)
        Store store = storeRepository.findByName(storeName)
                //    - 없으면 예외 터뜨린다
                .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

        if (page <= 0) {
            throw new ReviewException(ReviewErrorCode.INVALID_REQUEST);
        }


        //- 가게에 맞는 리뷰를 가져온다 (Offset 페이징)
        PageRequest pageRequest = PageRequest.of(page -1, 10);



        Page<Review> result = reviewRepository.findAllByStore(store, pageRequest);

        //- 결과를 응답 DTO로 변환한다 (컨버터 이용)
        return ReviewConverter.toReviewPreviewListDTO(result);
    }


    @Override
    public ReviewResDTO.ReviewPreViewListDTO findMyReviews(Long memberId, Integer page,
                                                           Long storeId, Float ratingGroup) {

        QReview review = QReview.review;

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));

        if (page <= 0) {
            throw new ReviewException(ReviewErrorCode.INVALID_REQUEST);
        }

        PageRequest pageRequest = PageRequest.of(page - 1, 10);

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(review.member.eq(member));

        if (storeId != null) {
            Store store = storeRepository.findById(storeId)
                    .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

            builder.and(review.store.eq(store));
        }

        if (ratingGroup != null) {
            double lower = ratingGroup;
            double upper = ratingGroup + 0.9;
            builder.and(review.score.between(lower, upper));
        }

        Page<Review> result =
                reviewRepository.findAllByCondition(builder, pageRequest);

        return ReviewConverter.toReviewPreviewListDTO(result);
    }


}
