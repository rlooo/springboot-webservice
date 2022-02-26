package com.eunyeong.book.springboot.web;

import com.eunyeong.book.springboot.service.user.UserService;
import com.eunyeong.book.springboot.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserApiController {
//    private final HttpSession httpSession;
    private final UserService userService;

//    @GetMapping("/auth/google/user")
//    public @ResponseBody
//    Map<String, Object> userInformation(){
//        Map<String, Object> userInfo = new HashMap<>();
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
//        if(user!=null){
//            userInfo.put("userName", user.getName());
//            userInfo.put("userEmail", user.getEmail());
//            userInfo.put("userPicture", user.getPicture());
//        }
//        return userInfo;
//    }

    @CrossOrigin("http://localhost:8080")
    @PostMapping(value = "/auth/google/user", consumes = "application/json")
    public Long save(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }
}
