package com.jcore.ehero.base.entities

import java.util.*

interface BaseEntity {
    val id: String
    val createDate: Date
    var updateDate: Date
    val createdBy: Long
    var isActive: Boolean
}
