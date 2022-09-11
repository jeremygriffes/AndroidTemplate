package net.slingspot.room.converter

import kotlinx.datetime.Instant
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ConvertersTest {
    @Nested
    @DisplayName("Given an Instant")
    inner class TestInstant {
        val converter = InstantConverter()
        val instant = Instant.parse("2022-09-11T01:25:24Z")

        @Nested
        @DisplayName("when serialized and deserialized, then")
        inner class When {
            private val deserialized = with(converter) {
                deserialize(serialize(instant))
            }

            @Test
            @DisplayName("the deserialized instant is equal to the original")
            fun then() {
                assertEquals(instant, deserialized)
            }
        }
    }

    @Nested
    @DisplayName("Given a list of strings")
    inner class TestStringList {
        val converter = StringListConverter()
        val list = listOf("Red", "Green", "Blue")

        @Nested
        @DisplayName("when serialized and deserialized, then")
        inner class When {
            private val deserialized = with(converter) {
                deserialize(serialize(list))
            }

            @Test
            @DisplayName("the deserialized list is equal to the original")
            fun then() {
                assertEquals(list, deserialized)
            }
        }
    }
}
