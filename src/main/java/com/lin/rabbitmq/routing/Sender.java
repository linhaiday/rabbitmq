package com.lin.rabbitmq.routing;

import com.lin.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * Created by apple on 2018/9/4.
 */
public class Sender {
    private final static String EXCHANGE_NAME = "exchange_direct";
    private final static String EXCHANGE_TYPE = "direct";

    public static void main(String[] args) throws IOException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME,EXCHANGE_TYPE);

        String message = "那一定是蓝色";
        channel.basicPublish(EXCHANGE_NAME,"key2", null, message.getBytes());
        System.out.println("[x] Sent '"+message+"'");

        channel.close();
        connection.close();
    }
}
