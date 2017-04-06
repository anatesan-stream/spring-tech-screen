package com.hrtest.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by anatesan on 3/31/2017.
 *
 CREATE TABLE EMPLOYEE(
 empNo      INTEGER NOT NULL,
 name       VARCHAR(10),
 job        VARCHAR(9),
 boss       INTEGER,
 hiredate   VARCHAR(12),
 salary     DECIMAL(7, 2),
 comm       DECIMAL(7, 2),
 deptNo     INTEGER
 );

 */
@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="EMPLOYEE")
public class Emp {


    @Column(nullable=false, name="empno")
    @Id
    private int empNo;

    @NonNull
    @Column(nullable=false)
    private String name;

    @NonNull
    @Column(nullable=false)
    private String job;

//    @Column
    @ManyToOne
    @JoinColumn(name="boss")
    private Emp boss;   // head guy will not have a boss

    @NonNull
    @Column(nullable=false)
    private String hiredate;

    @NonNull
    @Column(nullable=false)
    private Long salary;

    private Long comm;


//    @Column(nullable=false)
    @ManyToOne
    @JoinColumn(name="deptno")
    private Dept dept;

}
