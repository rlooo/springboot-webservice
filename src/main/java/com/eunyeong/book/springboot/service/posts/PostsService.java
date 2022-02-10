package com.eunyeong.book.springboot.service.posts;

import com.eunyeong.book.springboot.domain.posts.Posts;
import com.eunyeong.book.springboot.domain.posts.PostsRepository;
import com.eunyeong.book.springboot.web.dto.PostsListResponseDto;
import com.eunyeong.book.springboot.web.dto.PostsResponseDto;
import com.eunyeong.book.springboot.web.dto.PostsSaveRequestDto;
import com.eunyeong.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    private Long id;
    private PostsUpdateRequestDto requestDto;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        posts.update(requestDto. getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
    postsRepository.delete(posts);
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<PostsListResponseDto> searchPosts(String keyword) {
        return postsRepository.findByTitleContaining(keyword).stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}

