package com.inai.ai

import okhttp3.*
import org.json.JSONObject
import java.io.IOException

object OllamaClient {

    fun ask(
        prompt: String,
        onResult: (String) -> Unit
    ) {

        val client = OkHttpClient()

        val json = JSONObject()

        json.put("model", "inai")
        json.put("prompt", prompt)

        val body = RequestBody.create(
            MediaType.parse("application/json"),
            json.toString()
        )

        val request = Request.Builder()
            .url("http://127.0.0.1:11434/api/generate")
            .post(body)
            .build()

        client.newCall(request)
            .enqueue(object : Callback {

                override fun onFailure(
                    call: Call,
                    e: IOException
                ) {}

                override fun onResponse(
                    call: Call,
                    response: Response
                ) {

                    val result =
                        response.body()
                            ?.string()

                    if (result != null) {

                        val obj =
                            JSONObject(result)

                        val text =
                            obj.getString("response")

                        onResult(text)

                    }

                }

            })

    }

}