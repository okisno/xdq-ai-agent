package com.xdq.xdqaiagent.demo.invoke;

/**
 * @author xdq
 * @date 2025/5/15 17:27
 * @description SpringAiInvoke
 */

import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Spring AI 框架调用 AI 大模型（Ollama）
 *
 *      实现 CommandLineRunner 接口，在项目启动时调用，单次测试。
 */
@Component
public class OllamaAiInvoke implements CommandLineRunner {

    /**
     * 以名称注入 ChatModel，所以一定是 dashscope模型
     * ChatModel 是 Spring AI 框架的核心类，用于调用 AI 大模型。适用于简单的对话
     * ChatClient 是 Spring AI 框架的核心类，对话客户端，用于调用 AI 大模型。适用于复杂的对话
     */
    @Resource
    private ChatModel ollamaChatModel;


    /**
     * 项目启动时调用
     * @param args
     * @throws Exception
     * 调用call方法，传入 Prompt 对象，返回结果，得到GenerationResult 对象，再获取结果。
     */
    @Override
    public void run(String... args) throws Exception {
        AssistantMessage assistantMessage = ollamaChatModel.call(new Prompt("你好,什么是AI"))
                .getResult()
                .getOutput();
        System.out.println(assistantMessage.getText());
    }
}
