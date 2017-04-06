package com.hrtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author anatesan
 *
 * CREATE TABLE DEPARTMENT(
 *  deptno     INTEGER NOT NULL,
 *  name       VARCHAR(14),
 *  location   VARCHAR(13)
 *  );

 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DEPARTMENT")
public class Dept {
    @Column(nullable=false, name="deptno")
    @Id
    private int deptNo;

    @NonNull
    @Column(nullable=false)
    private String name;

    @Column
    private String location;
}
