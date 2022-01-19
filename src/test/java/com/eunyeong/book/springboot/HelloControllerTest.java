package com.eunyeong.book.springboot;
import com.eunyeong.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // 테스트 진행 시 SpringRunner라는 실행자 실행(스프링 부트 테스트와 JUnit 사이에 연결자 역할)
@WebMvcTest(controllers = {HelloController.class}, secure=false) //Web에 집중할 수 있는 어노테이션
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈(bean)을 주입받음
    private MockMvc mvc; // 웹 API를 테스트할 때 사용, 스프링 MVC 테스트의 시작점

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) // /hello 주소로 HTTP GET 요청
                .andExpect(status().isOk()) // 결과 검증 - HTTP Header의 Status 검증(200인지 아닌지 검증)
                .andExpect(content().string(hello)); // 결과 검증 - 응답 본문의 내용 검증(Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증)
    }
}
