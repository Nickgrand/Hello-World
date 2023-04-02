package com.qyf.mq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.Date;

/**
 * @author: HuiMing
 * @Date: Created in 2023/3/22 22:38
 * @ModifiedBy:
 */

public class Producer {
    public static void main(String[] args) throws MQClientException {
        //创建一个消息生产者，传入的是消息组名称
        DefaultMQProducer producer = new DefaultMQProducer("rmq-group");
        //输入nameserver服务的地址
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.setInstanceName("producer");
        //启动生产者
        producer.start();
        try {
            for (int i = 0; i < 10; i++) {
//                每秒发送一次mq
                Thread.sleep(1000);
//                创建消息，topic，tag，body
                Message msg = new Message("Topic-test",
                        "testTag",
                        (new Date() + " RocketMQ test msg " + i).getBytes());

                //发送，返回结果对象
                SendResult sendResult = producer.send(msg);

                System.out.println(sendResult.getMsgId());
                System.out.println(sendResult.getMessageQueue());
                System.out.println(sendResult.getSendStatus());
//                下一个要消费的消息的偏移量
                System.out.println(sendResult.getOffsetMsgId());
//                队列消息偏移量
                System.out.println(sendResult.getQueueOffset());
                System.out.println("================================================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.shutdown();
    }

}