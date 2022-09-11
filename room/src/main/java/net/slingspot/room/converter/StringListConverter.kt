package net.slingspot.room.converter

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal class StringListConverter : Converter<List<String>, String> {
    @TypeConverter
    override fun serialize(value: List<String>) = Json.encodeToString(value)

    @TypeConverter
    override fun deserialize(serialized: String) = Json.decodeFromString<List<String>>(serialized)
}
