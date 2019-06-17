package com.jcore.ehero.base.repositories.interfaces

import com.jcore.ehero.base.entities.BaseEntity

interface IBaseRepository<T: BaseEntity> {

    fun create(entity: T)

    fun update(entity: T)

    fun delete(entity: T)

    fun get(id: Long)
}