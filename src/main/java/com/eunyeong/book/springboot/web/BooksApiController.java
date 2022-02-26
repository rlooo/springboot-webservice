package com.eunyeong.book.springboot.web;

import com.eunyeong.book.springboot.service.books.BooksService;
import com.eunyeong.book.springboot.web.dto.BooksSaveRequestDto;
import com.eunyeong.book.springboot.web.dto.CollectInfoSaveRequestDto;
import com.eunyeong.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class BooksApiController {
    private final BooksService booksService;

    @PostMapping("/books/save")
    public Long booksSave(@RequestBody BooksSaveRequestDto bookRequestDto) {
        return booksService.save(bookRequestDto);
    }

    @PostMapping("/collectinfo/save")
    public Long collectInfoSave(@RequestBody CollectInfoSaveRequestDto collectInfoRequestDto) {
        return booksService.save(collectInfoRequestDto);
    }

    @GetMapping("/book/search")
    public @ResponseBody
    Map<String, Object> search(@RequestParam(value = "keyword") String keyword, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("bookList", booksService.searchBooks(keyword));
        return map;
    }


}
