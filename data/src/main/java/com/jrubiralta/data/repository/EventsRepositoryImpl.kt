package com.jrubiralta.data.repository

import com.jrubiralta.data.mapper.toModel
import com.jrubiralta.data.network.Network
import com.jrubiralta.domain.repository.EventsRepository
import com.jrubiralta.domain.repository.PollsRepository
import com.jrubiralta.portalbdn.persistence.Persistence

class EventsRepositoryImpl(
        private val network: Network,
        private val persistence: Persistence)
    : EventsRepository {

    override fun getEvents() =
            network.getEvents(persistence.getAccessToken())
                    .map { it.map { it.toModel() } }
}
