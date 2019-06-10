import com.alibaba.dubbo.common.threadpool.ThreadPool;
import sun.nio.ch.ServerSocketAdaptor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

/**
 * Created by wuwenhui on 2017/11/22.
 * since
 *
 * @version 1.0
 */
public class Main {


    static class CompletionHandlerimp implements CompletionHandler<AsynchronousSocketChannel, Object> {


        @Override
        public void completed(AsynchronousSocketChannel result, Object attachment) {
            try {
                System.out.println("client com"+result.getRemoteAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                HashMap info;
                ArrayList ainfo;
                ConcurrentHashMap mao;
                RandomAccessFile f = null;
                ThreadPool tool;
                try {
                    f = new RandomAccessFile("","r");
                    FileChannel fchan = f.getChannel();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }




            }

        }

        @Override
        public void failed(Throwable exc, Object attachment) {
            ServerSocketAdaptor d;

        }
    }


    public static void main(String[] a){
        System.out.print(1<<4);


//    AsynchronousSocketChannel chanl;
    try{
        AsynchronousChannelGroup group = AsynchronousChannelGroup.withThreadPool(Executors.newFixedThreadPool(4));
        AsynchronousServerSocketChannel sc = AsynchronousServerSocketChannel.open(group);
//        sc
//                .setOption(
//                        StandardSocketOption.SO_REUSEADDR,true);
//        sc
//                .setOption(
//                        StandardSocketOption.SO_RCVBUF,16*1024);
        InetSocketAddress addree = new InetSocketAddress("127.0.0.1",10000);

        sc.bind(addree);
        CompletionHandlerimp handled = new CompletionHandlerimp();
        sc.accept(null,handled);
        System.out.println("start>>>>>>.");

    }
    catch(Exception  e){
        e.printStackTrace();
    }

    }
}
