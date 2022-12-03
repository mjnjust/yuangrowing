package com.mj.learn.dubbo.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

public class Server {
    public static void main(String[] args) {
        //1.启动器，负责组转netty组件，启动服务器
        new ServerBootstrap()
                // 2.加入nio组的监听器（在里面包含selector选择器）
                .group(new NioEventLoopGroup())
                // 3.选择服务器的ServerSocketChannel实现
                .channel(NioServerSocketChannel.class)
                //4.boss负责处理连接   worker(child)负责处理读写，决定了worker(child)能执行哪些操作(handler)
                .childHandler(
                        //5.channel代表和客户端进行数据读写通道initializer初始化，负责添加其他的handler
                        new ChannelInitializer<NioSocketChannel>() {
                            //该方法是连接建立后才执行
                            protected void initChannel(NioSocketChannel ch) {
                                //6.添加具体的handler
                                ch.pipeline().addLast(new StringDecoder()); //将ByteBuf转换为字符串
                                ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {  //自定义handler
                                    @Override  //读事件
                                    protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                                        //打印上一步转换好的字符串
                                        System.out.println(msg);
                                    }
                                });
                            }
                        })
                //7.绑定监听器端口
                .bind(8080);
    }
}