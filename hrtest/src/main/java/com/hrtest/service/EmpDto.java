package com.hrtest.service;

import com.hrtest.entity.Dept;
import com.hrtest.entity.Emp;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

/**
 * Created by anatesan on 4/1/2017.
 * Return a domain DTO over Rest that is abstracted from DB structure
 *
 *
 */

@Data
@Builder
public class EmpDto {
    private int empno;

    @NonNull
    private String name;

    @NonNull
    private String job;

    private String bossName;

    @NonNull
    private String hiredate;

    @NonNull
    private Long salary;

    private Long comm;

    @NonNull
    private String deptName;

    @NonNull
    private String deptLocation;
}
