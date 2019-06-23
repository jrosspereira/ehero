package com.jcore.ehero.repositories.interfaces

import com.jcore.ehero.entities.Employee
import org.springframework.data.mongodb.repository.MongoRepository

interface EmployeeDAO : MongoRepository<Employee,String> {
}