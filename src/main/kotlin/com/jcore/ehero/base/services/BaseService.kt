package com.jcore.ehero.base.services

import com.jcore.ehero.base.entities.BaseEntity
import com.jcore.ehero.base.repositories.interfaces.IBaseRepository
import com.jcore.ehero.base.services.interfaces.IBaseService
import org.springframework.stereotype.Component

@Component
class BaseService<T: BaseEntity>(private val repository : IBaseRepository<T>) : IBaseService<T> {

    override fun create(entity: T) {
        repository.create(entity)
    }

    override fun update(entity: T) {
        repository.update(entity)
    }

    override fun delete(entity: T) {
        repository.delete(entity)
    }

    override fun get(id: Long) {
        repository.get(id)
    }



}
