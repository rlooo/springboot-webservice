package com.eunyeong.book.springboot.service.user;

import com.eunyeong.book.springboot.domain.user.User;
import com.eunyeong.book.springboot.domain.user.UserRepository;
import com.eunyeong.book.springboot.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long save(UserDto userDto) {
        return userRepository.save(userDto.toEntity()).getId();
    }

    @org.springframework.transaction.annotation.Transactional
    public User findUser(Long user_id) {
        return userRepository.findUserByid(user_id);
    }
}
