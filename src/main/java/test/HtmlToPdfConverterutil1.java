package test;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.*;
import java.nio.charset.StandardCharsets;
/**
 * @author GxDong
 * @createTime 2023/04/03 14:30
 * @className HtmlToPdfConverterutil1
 */
public class HtmlToPdfConverterutil1 {

    public static boolean convertToPdf(String html, String pdfPath) {
        try {
            // 设置页面大小和边距
            Rectangle pageSize = PageSize.A4;
            float marginLeft = 36;
            float marginRight = 36;
            float marginTop = 36;
            float marginBottom = 36;

            // 创建PDF文档
            Document document = new Document(pageSize, marginLeft, marginRight, marginTop, marginBottom);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfPath));

            // 打开文档
            document.open();

            // 添加HTML代码
            InputStream is = new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8));
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);

            // 关闭文档
            document.close();
            writer.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 从文件中获取文本，保持文件原状
     * @author guoming
     * @date   2023/3/9 15:09
     * @param  filePath 文件全路径
     * @return 文本
     **/
    public static String getStr1(String filePath) {
        File file = new File(filePath);
        Long length = file.length();
        byte[] content = new byte[length.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(content);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(content);
    }


    public static void main(String[] args)  {
        String str1 = getStr1("E:/aaa.txt");


        //System.out.println(path);
        boolean b = convertToPdf("str1" ,"D:/AA.pdf");
    }
}
