package julia.com.github.android_crypto_monitor.service

import julia.com.github.android_crypto_monitor.TickerResponse
import retrofit2.Response
import retrofit2.http.GET

interface MercadoBitcoinService {

    @GET("api/BTC/ticker/")
    suspend fun getTicker(): Response<TickerResponse>
}
//o response pega tudo oq esta na factory faz a chamada get e coloca dentro usando JSON
