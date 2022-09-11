package net.slingspot.room.converter

import androidx.room.TypeConverter
import kotlinx.datetime.Instant

internal class InstantConverter : Converter<Instant, Long> {
    @TypeConverter
    override fun serialize(value: Instant) = value.toEpochMilliseconds()

    @TypeConverter
    override fun deserialize(serialized: Long) = Instant.fromEpochMilliseconds(serialized)
}
