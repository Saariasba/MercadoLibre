package com.santi.mercadolibre.models

data class SearchResponse(
    val keywords: String? = "",
    val paging: Paging? = null,
    val results: List<Result>? = null
)

data class Paging(
    val total: Int? = 0,
    val offset: Int? = 0,
    val limit: Int? = 0
)

data class Result(
    val id: String? = "",
    val site_id: String? = "",
    val price: String? = "",
    val title: String? = "",
    val thumbnail: String? = ""
)
