package net.slingspot.core

interface NetworkApi {
    suspend fun fetch(
        path: String,
        headers: List<Pair<String, String>>
    ): String
}
