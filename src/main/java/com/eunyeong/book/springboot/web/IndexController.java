package com.eunyeong.book.springboot.web;

import com.eunyeong.book.springboot.domain.posts.PostsRepository;
import com.eunyeong.book.springboot.service.posts.PostsService;
import com.eunyeong.book.springboot.web.dto.PostsListResponseDto;
import com.eunyeong.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;


    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

//    @GetMapping("/book/search")
//    public @ResponseBody Map<String, Object> search(@RequestParam(value = "keyword") String keyword, Model model) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("postList", postsService.searchPosts(keyword));
//        return map;
//    }
//
//    @GetMapping("/auth/google/user")
//    public @ResponseBody Map<String, Object> userInformation(){
//        Map<String, Object> userInfo = new HashMap<>();
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
//        if(user!=null){
//            userInfo.put("userName", user.getName());
//            userInfo.put("userEmail", user.getEmail());
//            userInfo.put("userPicture", user.getPicture());
//        }
//        return userInfo;
//    }
}
