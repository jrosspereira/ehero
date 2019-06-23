package com.jcore.ehero.services

import com.jcore.ehero.base.exceptions.DAOException
import com.jcore.ehero.base.services.interfaces.IBaseCrudService
import com.jcore.ehero.entities.Employee
import com.jcore.ehero.repositories.interfaces.EmployeeDAO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class EmployeeService(val employeeDAO : EmployeeDAO): IBaseCrudService<String, Employee>{

    override fun findAll(pageable: Pageable): Page<Employee> = employeeDAO.findAll(pageable)

    override fun findById(id: String): Optional<Employee> = employeeDAO.findById(id)

    override fun insert(entity: Employee) =
        employeeDAO.insert(entity.apply {
            this.manager = entity.manager?.id?.let { employeeDAO.findById(it).get() }
        })

    @Throws(DAOException::class)
    override fun update(entity: Employee): Employee {
        return if(employeeDAO.existsById(entity.toString())){
            employeeDAO.save(entity.apply {
                this.manager = entity.manager?.id?.let { employeeDAO.findById(it).get() }
            })//re-insert manager from db to avoid inconsistency
        }else{
            throw DAOException("Employee not found")
        }
    }

    override fun deleteById(id: String): Optional<Employee> {
        return employeeDAO.findById(id).apply {
            this.ifPresent { employeeDAO.delete(it) }
        }
    }
}