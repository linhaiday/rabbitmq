package com.lin.rabbitmq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.lin.rabbitmq.util.ConnectionUtil;

import java.io.IOException;

/**
 * Created by apple on 2018/9/4.
 */
public class Sender {
    private final  static String QUEUE_NAME = "queue_work";

    public static void main(String[] args) throws IOException, InterruptedException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        for(int i = 0; i < 100; i++){
            String message = "冬马小三" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("[x] Sent '"+message + "'");
            Thread.sleep(i*10);
        }

        channel.close();
        connection.close();
    }
}
