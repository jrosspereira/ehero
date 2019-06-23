package com.jcore.ehero.base.services.interfaces

import com.jcore.ehero.base.entities.BaseEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface IBaseCrudService<K, T> where T : BaseEntity{

    fun findAll(pageable: Pageable): Page<T>

    fun findById(id:K):Optional<T>

    fun insert(entity :T):T

    fun update(entity:T):T

    fun deleteById(id: K):Optional<T>
}