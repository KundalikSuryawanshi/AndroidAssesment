package com.kundalik.manswiassesment.model

data class ResponseStatus(

    val access: String,
    val message: String,
    val name: String,
    val status: Boolean
)