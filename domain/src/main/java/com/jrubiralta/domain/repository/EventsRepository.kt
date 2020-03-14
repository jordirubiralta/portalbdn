package com.jrubiralta.domain.repository

import com.jrubiralta.domain.model.GetEventsResponseModel
import io.reactivex.Single

interface EventsRepository {
    fun getEvents(): Single<List<GetEventsResponseModel>>
}