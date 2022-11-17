package com.santi.mercadolibre.models

data class SearchResponse(
    val keywords: String? = "",
    val paging: ResponsePaging? = null,
    val results: List<ResponseResult>? = null
)

data class ResponsePaging(
    val total: Int? = 0,
    val offset: Int? = 0,
    val limit: Int? = 0
)

data class ResponseResult(
    val id: String? = "",
    val site_id: String? = "",
    val price: String? = "",
    val title: String? = "",
    val thumbnail: String? = ""
)
