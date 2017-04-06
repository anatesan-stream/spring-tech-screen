package com.hrtest.service;

/**
 * Created by anatesan on 4/4/2017.
 */

import com.google.common.collect.Iterables;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpServiceTests {

    @Autowired
    private EmpService service;

    @Test
    public void getExactlyOneEmp() {
        List<EmpDto> empDtoList = service.getEmpByEmpNo(7839);
        EmpDto empDto = empDtoList.get(0);
        Assert.assertEquals("KING", empDto.getName());
    }

    @Test
    public void getAllEmp() {
        Iterable<EmpDto> list = service.getAllEmp();
        int count = Iterables.size(list);
        Assert.assertEquals(14, count);
    }
}
