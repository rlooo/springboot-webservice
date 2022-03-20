package com.eunyeong.book.springboot.service.books;

import com.eunyeong.book.springboot.domain.books.*;
import com.eunyeong.book.springboot.domain.user.User;
import com.eunyeong.book.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BooksService {

    private final BooksRepository booksRepository;
    private final CollectInfoRepository collectInfoRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public Long saveBooks(BooksSaveRequestDto requestDto) {
        return booksRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long saveCollectInfo(CollectInfoSaveRequestDto collectInfoSaveRequestDto) { return collectInfoRepository.save(collectInfoSaveRequestDto.toEntity()).getSeq();}

    @Transactional
    public List<BooksListResponseDto> searchBooks(String keyword) {
        return booksRepository.findByTitleContaining(keyword).stream()
                .map(BooksListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Books findBooks(Long book_id) {
        return collectInfoRepository.findBookByid(book_id);
    }

    @Transactional
    public CollectInfo findCollectInfo(Long seq){return collectInfoRepository.findCollectInfoBySeq(seq);}

    @Transactional
    public Category findCategory(Long id) {return categoryRepository.findCategoryInfoById(id);}

    /**
     * collectInfo 수정
     */
    @Transactional
    public Long update(Long seq, CollectInfoUpdateRequestDto requestDto) {
        CollectInfo collectInfo = collectInfoRepository.findCollectInfoBySeq(seq);
//                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. seq=" + seq));
        collectInfo.update(requestDto.getState(), requestDto.getReturnDate(), requestDto.getReserveState(), requestDto.getExtensionCount(), requestDto.getUser());

        return seq;
    }

    /**
     * 대출현황 리스트 조회
     */
    @Transactional
    public List<CollectInfoListResponseDto> loanStatus(User user){
        return collectInfoRepository.loanStatus(user).stream()
                .map(CollectInfoListResponseDto::new)
                .collect(Collectors.toList());
    }

//    /**
//     * 예약버튼 활성화 검사
//     */
//    @Transactional
//    public Integer reserve(Books books){
//        //book에 연결된 모든 collectinfo의 카테고리별로 모두 대출중일 경우 예약가능하도록 한다.
//
//    }
//
//    /**
//     * 카테고리 별 책 불러오기
//     */
//    @Transactional
//    public List<CollectInfoListResponseDto> collectInfoByCategory(Category category) {
//        return CollectInfoRepository.findCollectInfoByCategory(category).stream()
//                .map(CollectInfoListResponseDto::new)
//                .collect(Collectors.toList());
//    }

}
