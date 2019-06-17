package com.jcore.ehero.base.interfaces

import com.jcore.ehero.base.entities.BaseEntity
import com.jcore.ehero.base.repositories.interfaces.IBaseRepository

class BaseRepository<T:BaseEntity> : IBaseRepository<T>{
    override fun update(entity: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(entity: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun create(entity: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}