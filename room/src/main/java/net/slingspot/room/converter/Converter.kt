package net.slingspot.room.converter

internal interface Converter<TYPE, SERIALIZED> {
    fun serialize(value: TYPE): SERIALIZED

    fun deserialize(serialized: SERIALIZED): TYPE
}
