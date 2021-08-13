package com.example.myfirstapp

import com.google.gson.annotations.SerializedName

data class PriceResponse constructor(
    @SerializedName("Valute")
    val valute: Map<String, Valute>? = null,
)

data class Valute(
    @SerializedName("ID")
    val id: String? = null,
    @SerializedName("NumCode")
    val numCode: Int? = null,
    @SerializedName("CharCode")
    val charCode: String? = null,
    @SerializedName("Nominal")
    val nominal: Int? = null,
    @SerializedName("Name")
    val name: String? = null,
    @SerializedName("Value")
    val value: Double? = null,
    @SerializedName("Previous")
    val previous: Double? = null
)