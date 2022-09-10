package net.slingspot.network

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import javax.inject.Inject
import net.slingspot.core.Logger as AppLogger

/**
 * Ktor implementation for REST calls.
 */
class NetworkRestKtor @Inject constructor(
    engine: HttpClientEngine,
    private val headerMap: HeaderMap,
    private val log: AppLogger,
) {
    private val client: HttpClient = HttpClient(engine) {
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    log.d(tag) { message }
                }
            }
            level = LogLevel.BODY
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

    private fun requestBuilder(path: String) = HttpRequestBuilder().apply {
        headerMap.default.forEach { header(it.key, it.value) }
        url(URLBuilder(path).build())
    }

    /**
     * Executes a GET request
     */
    suspend fun get(path: String) = client.get(requestBuilder(path))

    /**
     * Executes a POST request
     */
    suspend fun post(path: String) = client.post(requestBuilder(path))

    /**
     * Executes a PUT request
     */
    suspend fun put(path: String) = client.put(requestBuilder(path))

    /**
     * Executes a DELETE request
     */
    suspend fun delete(path: String) = client.delete(requestBuilder(path))

    companion object {
        private const val tag = "NetworkKtor"
    }
}
