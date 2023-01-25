package com.aveline.www.employeeleave.service;

import com.aveline.www.employeeleave.db.entity.EmployeeLeaveEntity;
import com.aveline.www.employeeleave.db.repository.EmployeeLeaveEntityRepository;
import com.aveline.www.employeeleave.model.WorkHourRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkHourService {
    @Autowired
    EmployeeLeaveEntityRepository employeeLeaveRepo;

    public Number getEmployeeLeaveCount(String employeeId){
        return employeeLeaveRepo.findById(employeeId).orElseThrow().getCount();
    }

    public List<EmployeeLeaveEntity> getAllEmployeesLeave(){
        return employeeLeaveRepo.findAll();
    }

    public void setEmployeeLeave(EmployeeLeaveEntity employeeLeave){
        employeeLeaveRepo.save(employeeLeave);
    }

    public Optional<EmployeeLeaveEntity> getEmployeeLeaveByEmployeeIdAndYearMonth(WorkHourRequest workHourRequest){
        Optional<EmployeeLeaveEntity> result = employeeLeaveRepo.findByEmployeeId(workHourRequest.getEmployeeId())
                .stream()
                .filter(EmployeeLeave -> Objects.equals(EmployeeLeave.getYearMonth().intValue(),
                        workHourRequest.getYearMonth().intValue())).findFirst();


        return result;
    }

//    public Optional<EmployeeLeaveEntity> getEmployeeLeaveByEmployeeIdAndYearMonth(String employeeId, Number yearMonth){
//        Optional<EmployeeLeaveEntity> result = employeeLeaveRepo.findByEmployeeId(employeeId)
//                .stream()
//                .filter(EmployeeLeave -> Objects.equals(EmployeeLeave.getYearMonth().intValue(),
//                        yearMonth.intValue())).findFirst();
//
//        return result;
//    }

    public void deleteEmployeeLeave(String id){
        this.employeeLeaveRepo.deleteById(id);
    }
}
