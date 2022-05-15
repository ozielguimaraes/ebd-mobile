package com.admp.ebd.data.remote

import com.admp.ebd.data.remote.exceptions.ApiErrorCodes
import com.admp.ebd.data.remote.exceptions.InternalServerErrorException
import com.admp.ebd.data.remote.exceptions.NoInternetConnectionException
import com.admp.ebd.data.remote.exceptions.UnauthorizedException
import com.admp.ebd.infrastructure.network.ResultWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response

open class BaseRemoteDataSource(
    private val dispatcher: CoroutineDispatcher,
    private val networkReachability: NetworkReachability
) {
    suspend fun <T : Any> apiCall(call: suspend () -> Response<T>): ResultWrapper<T?> =
        withContext(dispatcher) {
            if (networkReachability.isOnline()) {
                val response: Response<T>

                try {
                    response = call.invoke()

                    return@withContext when {
                        response.isSuccessful -> {
                            ResultWrapper.Success(response.body(), response.code())
                        }
                        response.code() == ApiErrorCodes.Unauthorized.code -> {
                            ResultWrapper.Error(
                                UnauthorizedException(
                                    response.errorBody()?.toString()
                                ),
                                response.code()
                            )
                        }
                        response.code() == ApiErrorCodes.InternalServerError.code -> {
                            ResultWrapper.Error(
                                InternalServerErrorException(
                                    response.errorBody()?.toString()
                                ),
                                response.code()
                            )
                        }
                        response.code() == ApiErrorCodes.NotFound.code -> {
                            ResultWrapper.Error(
                                Exception("NotFound"),
                                response.code()
                            )
                        }
                        response.code() == ApiErrorCodes.RequestTimeOut.code -> {
                            ResultWrapper.Error(
                                Exception("RequestTimeOut"),
                                response.code()
                            )
                        }
                        response.code() == ApiErrorCodes.GatewayTimeOut.code -> {
                            ResultWrapper.Error(
                                Exception("GatewayTimeOut"),
                                response.code()
                            )
                        }
                        else -> {
                            ResultWrapper.Error(
                                Exception("Not Treated"),
                                response.code()
                            )
                        }
                    }
                } catch (e: Exception) {
                    return@withContext ResultWrapper.Error(e, ApiErrorCodes.BadRequest.code)
                }
            } else {
                return@withContext ResultWrapper.Error(
                    NoInternetConnectionException(),
                    NO_NETWORK_CONNECTION_CODE
                )
            }
        }

    companion object {
        private const val NO_NETWORK_CONNECTION_CODE = -1
    }
}
