package net.slingspot.core.data

interface DataSource<KEY : Any, VALUE> {
    suspend fun read(key: KEY): VALUE
}

interface MutableDataSource<KEY : Any, VALUE> : DataSource<KEY, VALUE> {
    suspend fun write(key: KEY, value: VALUE)
}

interface Refreshable<KEY : Any, VALUE> : DataSource<KEY, VALUE> {
    suspend fun refresh(key: KEY): VALUE
}
