package com.jcore.ehero.services

import com.jcore.ehero.base.exceptions.DAOException
import com.jcore.ehero.base.services.interfaces.IBaseCrudService
import com.jcore.ehero.entities.Leave
import com.jcore.ehero.repositories.interfaces.EmployeeDAO
import com.jcore.ehero.repositories.interfaces.LeaveDAO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class LeaveService(val leaveDAO: LeaveDAO, private val employeeDAO: EmployeeDAO) : IBaseCrudService<String, Leave>{

    override fun findAll(pageable: Pageable): Page<Leave> = leaveDAO.findAll(pageable)

    override fun findById(id: String): Optional<Leave> = leaveDAO.findById(id)

    override fun insert(entity: Leave): Leave = leaveDAO.insert(entity.apply {
        this.approver = employeeDAO.findById(entity.approver.id).get()
    })

    @Throws(DAOException::class)
    override fun update(entity: Leave): Leave {
        return if(leaveDAO.existsById(entity.toString())){
            leaveDAO.save(entity.apply {
                this.employee = employeeDAO.findById(entity.employee.id).get()
                this.approver = employeeDAO.findById(entity.approver.id).get()
            })//re-insert manager from db to avoid inconsistency
        }else{
            throw DAOException("Leave not found")
        }
    }

    override fun deleteById(id: String): Optional<Leave> {
        return leaveDAO.findById(id).apply {
            this.ifPresent { leaveDAO.delete(it) }
        }
    }
}