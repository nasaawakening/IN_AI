package com.inai.ai

import okhttp3.*
import org.json.JSONObject
import java.io.IOException

object OllamaClient {

    fun streamResponse(
        prompt: String,
        onToken: (String) -> Unit
    ) {

        val client = OkHttpClient()

        val json = JSONObject()

        // MODEL YANG DIGUNAKAN
        json.put("model", "inai")

        // PROMPT AI
        json.put("prompt", prompt)

        // 🔥 AKTIFKAN STREAMING
        json.put("stream", true)

        val body = RequestBody.create(
            MediaType.parse("application/json"),
            json.toString()
        )

        val request = Request.Builder()
            .url("http://127.0.0.1:11434/api/generate")
            .post(body)
            .build()

        client.newCall(request).enqueue(
            object : Callback {

                override fun onFailure(
                    call: Call,
                    e: IOException
                ) {}

                override fun onResponse(
                    call: Call,
                    response: Response
                ) {

                    val reader =
                        response.body!!
                            .charStream()
                            .buffered()

                    reader.forEachLine {

                        val obj = JSONObject(it)

                        val token =
                            obj.getString("response")

                        onToken(token)

                    }

                }

            }
        )

    }

}