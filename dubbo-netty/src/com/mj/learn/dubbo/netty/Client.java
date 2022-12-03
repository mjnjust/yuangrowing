package com.mj.learn.dubbo.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Date;

public class Client {
    public static void main(String[] args) throws Exception {
//        new Bootstrap()
//                .group(new NioEventLoopGroup()) // 1
//                .channel(NioSocketChannel.class) // 2
//                .handler(new ChannelInitializer<Channel>() { // 3
//                    @Override
//                    protected void initChannel(Channel ch) {
//                        ch.pipeline().addLast(new StringEncoder()); // 8
//                    }
//                })
//                .connect("127.0.0.1", 8080) // 4
//                .sync() // 5
//                .channel() // 6
//                .writeAndFlush(new Date() + ": hello world!"); // 7

        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1", 8080));
        var out = socket.getOutputStream();
        out.write(new String("hello mjmj").getBytes());
        out.flush();
        Thread.sleep(10000);
    }
}
