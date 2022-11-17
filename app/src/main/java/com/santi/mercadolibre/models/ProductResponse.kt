package com.santi.mercadolibre.models

data class ProductResponse(
    val id: String? = "",
    val title: String? = "",
    val category_id: String? = "",
    val price: Int = 0,
    val secure_thumbnail: String = "",
    val original_price: Int = 0,
    val pictures: List<Picture> = listOf()
)

data class Picture(
    val id: String? = "",
    val secure_url: String? = ""
)
