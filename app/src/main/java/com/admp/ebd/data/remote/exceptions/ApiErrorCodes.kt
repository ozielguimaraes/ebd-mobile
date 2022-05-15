package com.admp.ebd.data.remote.exceptions

enum class ApiErrorCodes(val code: Int) {
    Unauthorized(401),
    BadRequest(400),
    NotFound(404),
    RequestTimeOut(408),
    InternalServerError(500),
    GatewayTimeOut(504)
}