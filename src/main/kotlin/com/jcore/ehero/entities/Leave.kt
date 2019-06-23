package com.jcore.ehero.entities

import com.jcore.ehero.base.entities.BaseEntity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Leave(@Id override val id: String,
                 override val createDate: Date,
                 override var updateDate: Date,
                 override val createdBy: Long,
                 override var isActive: Boolean,
                 var type: String,
                 var days: Int,
                 var isApproved: Boolean,
                 var employee: Employee,
                 var approver: Employee): BaseEntity {
}