import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by wuwenhui on 2017/11/23.
 * since
 *
 * @version 1.0
 */
public class Test2 {

    public static void main(String[] a){
        try {
            Socket socke = new Socket("192.168.23.131",9999);
//            byte[] bytes = new byte[1024];
//            int len = socke.getInputStream().read(bytes);
//            String context = new String(bytes,0,len);
//            System.out.println("收到"+context);
            OutputStream out = socke.getOutputStream();
            out.write("你还是【；；的咖啡深咖啡".getBytes());
            out.flush();
           out.close();
            socke.close();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
