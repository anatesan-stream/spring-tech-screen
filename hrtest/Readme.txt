Spring: JPA, Service, REST Test
===============================

Goal is here to demonstrate your JPA, Service and Rest Controller skills
using Spring Boot

Specifications
==============
1) DB Files given to you
    a) schema-h2.sql:  For this exercise, focus on Emp and Dept tables
    b) data-h2.sql: Populates data into above tables.

2) Using JPA, H2 Embedded DB, implement
    a) Dept & Emp entities
    b) Dept & Emp Repositories
    c) Service that exposes APIs as shown below

        /**
         * @param empno - specifies employee number to search for
         * @return List<EmpDto>
         */

        public List<EmpDto> getEmpByEmpNo(int empno)

            /**
             * Returns all Emp in Repository
             * @return List<EmpDto>
             */
        public List<EmpDto> getAllEmp()

        EmpDto structure needs to be derived from Rest Call Output
        below

    d) Expose these APIs via 2 rest GET services

    http://localhost:8080/employees  returns a JSON array in this format
    with one entry per row in the DB

          [{
                  empno: 7369,
                  name: "SMITH",
                  job: "CLERK",
                  bossName: "FORD",
                  hiredate: "1980-12-17",
                  salary: 800,
                  comm: null,
                  deptName: "RESEARCH",
                  deptLocation: "DALLAS"
              },
              {..},
              {..},
              {..},
              {..},
              {..},
              {..},
              {..},
              {..},
              {..},
              {..},
              {..},
              {..},
              {..}
          ]

    http://localhost:8080/employee/7369  (note empno specification) Returns
    a single element matching the empno

    [{
            empno: 7369,
            name: "SMITH",
            job: "CLERK",
            bossName: "FORD",
            hiredate: "1980-12-17",
            salary: 800,
            comm: null,
            deptName: "RESEARCH",
            deptLocation: "DALLAS"
        }
    ]
