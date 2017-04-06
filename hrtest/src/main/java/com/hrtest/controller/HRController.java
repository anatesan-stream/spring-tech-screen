package com.hrtest.controller;

import com.hrtest.service.EmpDto;
import com.hrtest.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by anatesan on 4/1/2017.
 */
@RestController
public class HRController {

    @Autowired
    private EmpService empService;

    @RequestMapping(path="/employee/{empno}",
            method= RequestMethod.GET,
            produces="application/JSON" )
    public List<EmpDto> getEmpDtoByEmpNo(@PathVariable("empno") int empno) {
        return this.empService.getEmpByEmpNo(empno);
    }

    @RequestMapping(path="/employees",
            method= RequestMethod.GET,
            produces="application/JSON" )
    public List<EmpDto> getAllEmp() {
        return this.empService.getAllEmp();
    }
}
