package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class ImageToBase64Util {

    /**
     * 将文件转换为Base64编码字符串
     *
     * @param file 要转换的文件
     * @return Base64编码字符串
     * @throws IOException 如果读取文件时发生错误
     */
    public static String encode(File file) throws IOException {
        byte[] bytes = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(bytes);
        fileInputStream.close();
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * 将指定路径下的文件转换为Base64编码字符串
     *
     * @param filePath 文件路径
     * @return Base64编码字符串
     * @throws IOException 如果读取文件时发生错误
     */
    public static String encode(String filePath) throws IOException {
        File file = new File(filePath);
        return encode(file);
    }

    public static void main(String[] args) {
        String t=null;
        try {
            t=encode("E:/GxDong_2023-04-03_14-12-48.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(t);
    }
}
