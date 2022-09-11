package net.slingspot.room.app

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import net.slingspot.room.converter.InstantConverter
import net.slingspot.room.converter.StringListConverter

@Database(
    entities = [
        ExampleEntity::class,
    ], version = VERSION
)
@TypeConverters(
    InstantConverter::class,
    StringListConverter::class,
)
internal abstract class AppDatabase : RoomDatabase() {
    internal abstract fun appDao(): AppDao
}
