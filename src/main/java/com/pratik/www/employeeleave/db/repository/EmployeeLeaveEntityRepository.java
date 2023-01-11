package com.pratik.www.employeeleave.db.repository;

import com.pratik.www.employeeleave.db.entity.EmployeeLeaveEntity;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeLeaveEntityRepository extends CouchbaseRepository<EmployeeLeaveEntity,String> {
    List<EmployeeLeaveEntity> findByEmployeeId(String employeeId);
}
