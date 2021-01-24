package br.com.rafaelmacedo

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.logging.Logger

class RemoteProvider(private val client: OkHttpClient) {

    fun request() {
        val request = Request.Builder()
            .url("https://apidojo-yahoo-finance-v1.p.rapidapi.com/auto-complete?q=tesla&region=US")
            .get()
            .addHeader("x-rapidapi-key", "9fb78fd48dmsh443da60d9462ea2p14641fjsn3feeff5788c7")
            .addHeader("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
            .build()

        Log.i("Response", client.newCall(request).execute().body?.string() ?: "")

    }
}