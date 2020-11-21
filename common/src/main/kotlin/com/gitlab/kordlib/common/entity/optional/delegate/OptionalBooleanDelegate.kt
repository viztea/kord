package com.gitlab.kordlib.common.entity.optional.delegate

import com.gitlab.kordlib.common.entity.optional.OptionalBoolean
import com.gitlab.kordlib.common.entity.optional.optional
import com.gitlab.kordlib.common.entity.optional.value
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KProperty

fun KMutableProperty0<OptionalBoolean>.delegate(): ReadWriteProperty<Any?, Boolean?> = object : ReadWriteProperty<Any?, Boolean?> {

    override fun getValue(thisRef: Any?, property: KProperty<*>): Boolean? {
        return this@delegate.get().value
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Boolean?) {
        val optional = if (value == null) OptionalBoolean.Missing
        else OptionalBoolean.Value(value)
        this@delegate.set(optional)
    }

}

@JvmName("provideNullableDelegate")
fun <T> KMutableProperty0<OptionalBoolean?>.delegate(): ReadWriteProperty<T, Boolean?> = object : ReadWriteProperty<T, Boolean?> {

    override fun getValue(thisRef: T, property: KProperty<*>): Boolean? {
        return this@delegate.get().value
    }

    override fun setValue(thisRef: T, property: KProperty<*>, value: Boolean?) {
        this@delegate.set(value?.optional())
    }

}