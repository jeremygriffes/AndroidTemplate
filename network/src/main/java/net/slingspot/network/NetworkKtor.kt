package net.slingspot.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import net.slingspot.core.NetworkApi
import javax.inject.Inject

class NetworkKtor @Inject constructor(
    engine: HttpClientEngine
) : NetworkApi {
    private val client: HttpClient = HttpClient(engine) {
        install(Logging) {
            level = LogLevel.ALL
            logger = Logger.DEFAULT
        }

        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                }
            )
        }
    }

    private fun request(
        path: String,
        headers: List<Pair<String, String>> = emptyList()
    ) = HttpRequestBuilder().apply {
        headers.forEach {
            header(it.first, it.second)
        }
        url(URLBuilder(path).build())
    }

    override suspend fun fetch(
        path: String,
        headers: List<Pair<String, String>>
    ): String =
        client.get(request(path, headers)).body()
}
