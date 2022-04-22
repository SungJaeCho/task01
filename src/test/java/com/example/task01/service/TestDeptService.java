package com.example.task01.service;

import com.example.task01.domain.Dept;
import com.example.task01.repository.DeptRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestDeptService {
    private static final Logger log = LoggerFactory.getLogger(TestDeptService.class);

    @Mock
//    @Autowired
    private DeptRepository deptRepository;

    @Test
    public void A001_DETP_데이터_삽입() {
        Dept dept = new Dept(10L, "1 부서명", "1 부서위치");
        deptRepository.save(dept);
    }

    @Test
    public void A002_DEPT_데이터_조회() {
        Dept dept = new Dept(10L, "1 부서명", "1 부서위치");
        deptRepository.save(dept);

        boolean isResult = deptRepository.findById(10L).isPresent();
        if(isResult) {
            log.debug(deptRepository.findById(10L).get().toString());
        } else {
            log.error("Not found Data");
        }
    }

    @Test
    public void AOO3_DEPT_데이터_삭제() {
        Dept dept = new Dept(10L, "1 부서명", "1 부서위치");
        deptRepository.delete(dept);
    }
}
