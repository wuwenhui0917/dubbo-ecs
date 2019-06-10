package com.ecs.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by wuwenhui on 2018/1/16.
 * since
 *
 * @version 1.0
 */
public class NioSocket {

    public void init() throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.socket().bind(new InetSocketAddress("127.0.0.1", 10000));
        serverChannel.configureBlocking(false);
        // 创建一个选择器并将serverChannel注册到它上面  
        Selector selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            selector.select();
            Set<SelectionKey> readySelectionKey = selector
                    .selectedKeys();
            Iterator<SelectionKey> it = readySelectionKey.iterator();
            while (it.hasNext()) {
                SelectionKey selectionKey = it.next();
                // 判断是哪个事件
                if (selectionKey.isAcceptable()) {// 客户请求连接
                    System.out.println(selectionKey.attachment()
                            + " - 接受请求事件");
                    // 获取通道 接受连接,
                    // 设置非阻塞模式（必须），同时需要注册 读写数据的事件，这样有消息触发时才能捕获
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey
                            .channel();
                    SocketChannel client = serverSocketChannel
                            .accept();

                    client.configureBlocking(false);
                    client.register(
                            selector,
                            SelectionKey.OP_READ
                                    | SelectionKey.OP_WRITE);
                    System.out
                            .println(selectionKey.attachment() + " - 已连接");


                }
                if (selectionKey.isReadable()) {// 读数据
                    System.out.println(selectionKey.attachment()
                            + " - 读数据事件");
                    SocketChannel clientChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer receiveBuf = ByteBuffer.allocate(1024);
                    clientChannel.read(receiveBuf);

                }
                if (selectionKey.isWritable()) {// 写数据
                    System.out.println(selectionKey.attachment()
                            + " - 写数据事件");
                    SocketChannel clientChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer sendBuf = ByteBuffer.allocate(11);
                    String sendText = "hello word";
                    sendBuf.put(sendText.getBytes());
                    sendBuf.flip();        //写完数据后调用此方法
                    clientChannel.write(sendBuf);
                }
                if (selectionKey.isConnectable()) {
                    System.out.println(selectionKey.attachment()
                            + " - 连接事件");
                }
                // 必须removed 否则会继续存在，下一次循环还会进来,
                // 注意removed 的位置，针对一个.next() remove一次
                it.remove();
            }
        }
    }


}
