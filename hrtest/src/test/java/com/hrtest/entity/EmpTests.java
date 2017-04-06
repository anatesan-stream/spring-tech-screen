package com.hrtest.entity;

/**
 * Created by anatesan on 4/2/2017.   Tests for Dept Entity
 */

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmpTests {

/*    @Rule
    public Emp fullEmp = Emp.builder().empNo(1)
            .hiredate("01/05/2015")
            .name("full name")
            .salary(20000L)
            .comm(10000L)
            .job("Engineer")
            .dept(new Dept(10, "Engineering", "Sunnyvale"))
            .build();*/

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void setEmpWhenNonNullableFieldIsNullShouldThrowException() throws Exception {

        Emp fullEmp = Emp.builder().empNo(1)
                .hiredate("01/05/2015")
                .name("full name")
                .salary(20000L)
                .comm(10000L)
                .job("Engineer")
                .dept(new Dept(10, "Engineering", "Sunnyvale"))
                .build();

        this.thrown.expect(NullPointerException.class);
        fullEmp.setHiredate(null); // HireDate cannot be null

        this.thrown.expect(NullPointerException.class);
        fullEmp.setDept(null); // dept cannot be null

        this.thrown.expect(NullPointerException.class);
        fullEmp.setName(null); // name cannot be null

        this.thrown.expect(NullPointerException.class);
        fullEmp.setSalary(null); // salary cannot be null

        this.thrown.expect(NullPointerException.class);
        fullEmp.setJob(null); // job cannot be null
    }

    @Test
    public void setEmpOnNullableFieldIsNullShouldNotThrowException() throws Exception {

        Emp fullEmp = Emp.builder().empNo(1)
                .hiredate("01/05/2015")
                .name("full name")
                .salary(20000L)
                .comm(10000L)
                .job("Engineer")
                .dept(new Dept(10, "Engineering", "Sunnyvale"))
                .build();

        fullEmp.setComm(null);
        fullEmp.setBoss(null);


    }

}
