package com.example.killreal.data.core

class ResponseCodeException(val errorCode:Int, private val needCode:Int):Exception() {
    override val message: String
        get() = "Response code exception: errorCode = $errorCode, needCode = $needCode"
}