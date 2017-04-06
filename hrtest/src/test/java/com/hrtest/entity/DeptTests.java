package com.hrtest.entity;

/**
 * Created by anatesan on 4/2/2017.   Tests for Dept Entity
 */

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class DeptTests {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    // Don't need to test null Deptno - compiler catches it.
    @Test
    public void createDeptWhenNameIsNullShouldThrowException() throws Exception {
        this.thrown.expect(NullPointerException.class);
        new Dept(10, null, "Location");
    }

    @Test
    public void createDeptWhenLocationIsNullShouldNotThrowException() throws Exception {
        Dept testDept = new Dept(10, "Ashok", null);
        Assert.assertNotNull(testDept);
        Assert.assertNull(testDept.getLocation());
        Assert.assertNotNull(testDept.getName());

    }

}
