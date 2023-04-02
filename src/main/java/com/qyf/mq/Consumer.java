package com.qyf.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author: HuiMing
 * @Date: Created in 2023/3/22 22:42
 * @ModifiedBy:
 */

public class Consumer {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("rmq-group");

        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.setInstanceName("consumer");
//        订阅某个主题，然后使用tag过滤消息，不过滤可以用*代表
        consumer.subscribe("Topic-test", "testTag");

//        注册监听回调实现类来处理broker推送过来的消息,MessageListenerConcurrently是并发消费
        consumer.registerMessageListener((MessageListenerConcurrently) (messages, context) -> {
            for (MessageExt msg : messages) {
                System.out.println(msg.getMsgId() + " ===== " + new String(msg.getBody()));
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
//        消费者启动完成
        consumer.start();
        System.out.println("com.qyf.mq.Consumer Started.");
    }
}
