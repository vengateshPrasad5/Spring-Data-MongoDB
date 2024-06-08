package com.taskx.Spring.Data.MongoDB.Repository;

import com.taskx.Spring.Data.MongoDB.Entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {
}
