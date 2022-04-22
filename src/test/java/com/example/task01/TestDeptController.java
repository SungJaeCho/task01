package com.example.task01;

import com.example.task01.domain.Dept;
import com.example.task01.service.DeptService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest // 스프링 환경으로 테스트한다는 의미 꼭 넣어야함
public class TestDeptController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeptService deptService;

    @Test
    public void dept_저장테스트() throws Exception {
        Dept dept = new Dept(null, "platform", "4F");
        // given (테스트를 하기위한 준비)
        String content = new ObjectMapper().writeValueAsString(dept);
        // stub(행동 미리 지정) 단위테스트에서만 필요
        when(deptService.save(dept)).thenReturn(new Dept(1L, "platform", "4F"));

        // when (테스트 실행)
        ResultActions resultAction = mockMvc.perform(post("/api/dept")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)
                .accept(MediaType.APPLICATION_JSON));

        // then (검증)
        resultAction.andExpect(status().isCreated())
                .andExpect(jsonPath("$.ioc").value("platform")) // JsonPath문법에 따라 처리
                .andDo(MockMvcResultHandlers.print());
    }

}
