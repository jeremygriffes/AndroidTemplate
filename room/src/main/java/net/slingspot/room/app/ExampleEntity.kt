package net.slingspot.room.app

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.Instant

@Entity
internal data class ExampleEntity(
    @PrimaryKey
    val key: String,
    val timestamp: Instant,
    val names: List<String>,
)
