package com.jcore.ehero.entities

import com.jcore.ehero.base.entities.BaseEntity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Employee(@Id override val id: String,
                    override val createDate: Date,
                    override var updateDate: Date,
                    override val createdBy: Long,
                    override var isActive: Boolean,
                    @Indexed(unique = true) val emailAddress: String,
                    var firstName: String,
                    var lastName: String,
                    var manager: Employee?) : BaseEntity {
}