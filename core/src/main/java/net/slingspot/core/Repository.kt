package net.slingspot.core

import javax.inject.Inject

interface Repository {
    suspend fun fetch(): String

    class Default @Inject constructor(private val network: NetworkApi) : Repository {

        override suspend fun fetch(): String {
            return network.fetch("https://slingspot.net", listOf())
        }
    }
}
