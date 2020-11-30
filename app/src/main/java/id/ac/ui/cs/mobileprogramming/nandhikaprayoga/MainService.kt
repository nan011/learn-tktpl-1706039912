package id.ac.ui.cs.mobileprogramming.nandhikaprayoga

import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

class MainService {
    enum class HttpMethod(val value: String) {
        GET("GET"),
        POST("POST"),
    }

    companion object {
        private const val API_DOMAIN = "https://postman-echo.com"

        fun getAPIUri(endpoint: String): String {
            return "${API_DOMAIN}${endpoint}"
        }

        fun sendRequest(
            callback: Callback,
            uri: String,
            method: HttpMethod = HttpMethod.GET,
            body: RequestBody? = null,
        ) {
            val client: OkHttpClient = OkHttpClient().newBuilder().build()
            val rawRequest: Request.Builder = Request.Builder()
                .url(uri)
                .method(method.value, body)

            val request: Request = rawRequest.build()
            client.newCall(request).enqueue(callback)
        }
    }
}