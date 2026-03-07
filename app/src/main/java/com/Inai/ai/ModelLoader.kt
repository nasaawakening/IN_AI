package com.inai.ai

object ModelLoader {

    private var currentModel = "inai"

    fun setModel(name: String) {
        currentModel = name
    }

    fun askAI(
        prompt: String,
        onResult: (String) -> Unit
    ) {

        OllamaClient.ask(
            model = currentModel,
            prompt = prompt,
            onResult = onResult
        )

    }

}