package net.slingspot.room.app

import androidx.room.*

@Dao
internal interface AppDao {
    @Query("SELECT * FROM exampleentity WHERE key = :key")
    fun getExampleEntity(key: String): ExampleEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entity: ExampleEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(entity: ExampleEntity)
}
