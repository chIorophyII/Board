package com.example.testproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PostTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private HttpHeaders headers;
    private ObjectMapper mapper = new ObjectMapper();

    private final List<PostDto> writedPost = new ArrayList<>();

    @BeforeEach
    public void setup() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Test
    @Order(1)
    @DisplayName("게시판 글 작성")
    void writePost() throws JsonProcessingException {
        // given
        PostDto postRequest = PostDto.builder()
                .id(null)
                .title("new title")
                .content("new content")
                .build();

        String requestBody = mapper.writeValueAsString(postRequest);
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        // when
        ResponseEntity<PostDto> response = restTemplate.postForEntity(
                "/post",
                request,
                PostDto.class);

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());

        PostDto postResponse = response.getBody();
        assertNotNull(postResponse);;
        assertTrue(postResponse.id > 0);
        assertEquals(postRequest.title, postResponse.title);
        assertEquals(postRequest.content, postResponse.content);
    }

    @Getter
    @Setter
    @Builder
    static class PostDto {
        private Long id;
        private String title;
        private String content;
    }
}