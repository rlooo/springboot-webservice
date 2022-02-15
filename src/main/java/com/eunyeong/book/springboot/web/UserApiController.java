package com.eunyeong.book.springboot.web;

import com.eunyeong.book.springboot.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final HttpSession httpSession;

    @GetMapping("/auth/google/user")
    public @ResponseBody
    Map<String, Object> userInformation(){
        Map<String, Object> userInfo = new HashMap<>();
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user!=null){
            userInfo.put("userName", user.getName());
            userInfo.put("userEmail", user.getEmail());
            userInfo.put("userPicture", user.getPicture());
        }
        return userInfo;
    }
}
