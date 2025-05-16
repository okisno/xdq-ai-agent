package com.xdq.xdqaiagent.demo.invoke;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.chat.ChatLanguageModel;
import jakarta.annotation.Resource;

/**
 * @author xdq
 * @date 2025/5/15 19:25
 * @description LanChainAiInvoke
 */
public class LanChainAiInvoke {

    public static void main(String[] args) {
        ChatLanguageModel qwenChatModel = QwenChatModel.builder()
                .apiKey(TestApiKey.API_KEY)
                .modelName("qwen-max")
                .build();
        String answer = qwenChatModel.chat("你好");
        System.out.println(answer);
    }

}
