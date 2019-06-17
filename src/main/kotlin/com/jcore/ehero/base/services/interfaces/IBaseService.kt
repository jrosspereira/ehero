package com.jcore.ehero.base.services.interfaces

import com.jcore.ehero.base.entities.BaseEntity

interface IBaseService<T: BaseEntity>{

    fun create(entity: T)

    fun update(entity: T)

    fun delete(entity: T)

    fun get(id: Long)
}