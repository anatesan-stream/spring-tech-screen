package com.hrtest.service;

import com.hrtest.entity.Emp;
import com.hrtest.repository.DeptRepository;
import com.hrtest.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anatesan on 4/1/2017.
 *
 */
@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    @Autowired
    private DeptRepository deptRepository;

    /**
     * @param empno - specifies employee number to search for
     * @return List<EmpDto>
     */
    public List<EmpDto> getEmpByEmpNo(int empno) {
        ArrayList<EmpDto> list = new ArrayList<>();
        Emp foundEmp = empRepository.findByEmpNo(empno);
        if (foundEmp!=null) {
            list.add(getEmpDtoFromEmp(foundEmp));
        }
        return list;
    }
    
    private EmpDto getEmpDtoFromEmp(Emp emp) {
        EmpDto empDto = EmpDto.builder()
                .empno(emp.getEmpNo())
                .name(emp.getName())
                .job(emp.getJob())
                .bossName((emp.getBoss()==null)?null:emp.getBoss().getName())
                .hiredate(emp.getHiredate())
                .comm(emp.getComm())
                .salary(emp.getSalary())
                .deptName(emp.getDept().getName())
                .deptLocation(emp.getDept().getLocation())
                .build();
        return empDto;
    }

    /**
     * Returns all Emp in Repository
     * @return List<EmpDto>
     */
    public List<EmpDto> getAllEmp() {
        Iterable<Emp> listEmp = empRepository.findAll();
        ArrayList<EmpDto> listEmpDto = new ArrayList<>();

        listEmp.forEach((Emp emp) -> {
            listEmpDto.add(getEmpDtoFromEmp(emp));
        });

        return listEmpDto;
    }
}
