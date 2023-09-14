package test;


import cn.hutool.core.util.StrUtil;
import org.apache.commons.lang3.time.DateUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author GxDong
 * @createTime 2023/04/03 16:10
 * @className Base64ImgReplacedElementFactory
 * \u000a 表示换行符 (Line Feed)。
 * \u007d 表示右花括号 }。
 * \u007b 表示左花括号 {。
 */
public class Base64ImgReplacedElementFactory {
    public static void main(String[] args) {
        if(true == false){
            //these characters are magic:
            // \u000a\u007d\u007b
            System.out.println("this is false");
        }

    }
}
