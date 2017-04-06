package com.hrtest.repository;

import com.google.common.collect.Iterables;
import com.hrtest.entity.Emp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
/**
 * Created by anatesan on 4/3/2017.
 */
public class EmpRepositoryTests {

    @Autowired
    private EmpRepository empRepository;

    @Test
    public void getExactlyOneEmp() {
        Emp testEmp = empRepository.findByEmpNo(7839);
        Assert.assertEquals("KING", testEmp.getName());
    }

    @Test
    public void getAllEmp() {
        Iterable<Emp> list = empRepository.findAll();
        int count = Iterables.size(list);
        Assert.assertEquals(14, count);
    }
}
