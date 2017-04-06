package com.hrtest.repository;

import com.hrtest.entity.Emp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by anatesan on 4/1/2017.
 */
public interface EmpRepository extends CrudRepository<Emp,Long> {
    public Emp findByEmpNo(int empNo);
    public Emp findByName(String name);
    public List<Emp> findByDeptDeptNo(int deptNo);
}
