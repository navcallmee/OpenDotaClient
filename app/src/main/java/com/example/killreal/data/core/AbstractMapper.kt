package com.example.killreal.data.core

abstract class AbstractMapper<T, E> {
    abstract fun map(data: T): E
}