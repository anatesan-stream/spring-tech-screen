package com.hrtest.repository;

import com.hrtest.entity.Dept;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * Created by anatesan on 4/1/2017.
 */

public interface DeptRepository extends CrudRepository<Dept, Long> {
}
