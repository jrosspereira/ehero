package com.jcore.ehero.repositories.interfaces

import com.jcore.ehero.entities.Leave
import org.springframework.data.mongodb.repository.MongoRepository

interface LeaveDAO : MongoRepository<Leave, String> {
    fun findByApproverId(id:String):List<Leave>
}