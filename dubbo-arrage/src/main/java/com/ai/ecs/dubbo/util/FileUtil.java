package com.ai.ecs.dubbo.util;

import java.io.*;

/**
 * Created by Administrator on 2017/8/3.
 */
public class FileUtil {

    /**
     * 读取小文件（低于1G一下的文件工具类）
     * @param fileName
     * @return
     */
    public static String getFileContent(String fileName){
        File f = new File(fileName);
        FileReader reader = null;
        BufferedReader br = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader= new FileReader(f);
            br = new BufferedReader(reader);
            try {
                String line = br.readLine();
                while(line!=null){
                    builder.append(line);
                    line = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if(br!=null){
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(reader!=null){
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return builder.toString();

    }


    public static void writeFile(String fileName,String fileContent){
        File f = new File(fileName);
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileWriter wr = null;
        try {
             wr= new FileWriter(f);
             wr.write(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(wr!=null){
                try {
                    wr.flush();
                    wr.close();
                    wr = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }

    }
}
