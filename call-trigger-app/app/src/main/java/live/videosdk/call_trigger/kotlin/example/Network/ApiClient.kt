package live.videosdk.call_trigger.kotlin.example.Network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


object ApiClient {
    private const val BASE_URL = "http://172.20.10.6:9000/"
    private var retrofit: Retrofit? = null

    val client: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL) // ScalarsConverterFactory handles plain text responses
                    .addConverterFactory(ScalarsConverterFactory.create()) // GsonConverterFactory handles JSON responses
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}
