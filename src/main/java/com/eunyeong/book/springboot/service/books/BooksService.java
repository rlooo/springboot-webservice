package com.eunyeong.book.springboot.service.books;

import com.eunyeong.book.springboot.domain.books.BooksRepository;
import com.eunyeong.book.springboot.domain.books.CollectInfo;
import com.eunyeong.book.springboot.domain.books.CollectInfoRepository;
import com.eunyeong.book.springboot.web.dto.BooksListResponseDto;
import com.eunyeong.book.springboot.web.dto.BooksSaveRequestDto;
import com.eunyeong.book.springboot.web.dto.CollectInfoSaveRequestDto;
import com.eunyeong.book.springboot.web.dto.PostsSaveRequestDto;
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

    @Transactional
    public Long save(BooksSaveRequestDto requestDto) {
        return booksRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long save(CollectInfoSaveRequestDto collectInfoSaveRequestDto) { return collectInfoRepository.save(collectInfoSaveRequestDto.toEntity()).getSeq();}

    @Transactional
    public List<BooksListResponseDto> searchBooks(String keyword) {
        return booksRepository.findByTitleContaining(keyword).stream()
                .map(BooksListResponseDto::new)
                .collect(Collectors.toList());
    }

}
