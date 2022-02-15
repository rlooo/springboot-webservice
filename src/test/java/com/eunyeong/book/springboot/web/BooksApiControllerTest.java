package com.eunyeong.book.springboot.web;

import com.eunyeong.book.springboot.domain.books.Books;
import com.eunyeong.book.springboot.domain.books.BooksRepository;
import com.eunyeong.book.springboot.domain.posts.Posts;
import com.eunyeong.book.springboot.domain.posts.PostsRepository;
import com.eunyeong.book.springboot.web.dto.BooksSaveRequestDto;
import com.eunyeong.book.springboot.web.dto.PostsSaveRequestDto;
import com.eunyeong.book.springboot.web.dto.PostsUpdateRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BooksApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @After
    public void tearDown() throws Exception {
        booksRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles="USER")
    public void Books_등록된다() throws Exception {
        String title = "test";
        String thumbnail = "test";
        String author = "test";
        String sign = "test";
        String publish = "test";
        String shape = "test";

        BooksSaveRequestDto requestDto = BooksSaveRequestDto.builder()
                .title(title)
                .thumbnail(thumbnail)
                .author(author)
                .sign(sign)
                .publish(publish)
                .shape(shape)
                .build();

        String url = "http://localhost:" +port+ "/books/save";

        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Books> all = booksRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getThumbnail()).isEqualTo(thumbnail);

    }


}
