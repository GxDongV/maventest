
package test;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * @author GxDong
 * @create 2022/08/30 8:52:57
 * @class excl
 * 操作Excel文件区分版本：
 * <p>
 * 2003版本（包含2003）以前的扩展名为.xls需要用HSSFWorkbook类操作
 * 2007版本（包含2007）以后的扩展名为.xlsx需要用XSSFWorkbook类操作
 */

public class Excl {
    public static void main(String[] args) throws Exception {

        XSSFWorkbook sheets = execlToAll("D:/Exceltext/test2.xlsx", 2);
        //写文件
        out(sheets,"D:/Exceltext/outtest1.xlsx");
    }

    /**
     * execl sheet合并
     * -------需要输出的文件与要处理的文件不能为同一个文件
     *
     * @param inputPath 要处理的文件路径（全路径）
     * @param tableType 0 不去掉表头 1 去掉表头 2 保留第一个sheet的表头
     * @return XSSFWorkbook
     */
    public static XSSFWorkbook execlToAll(String inputPath, int tableType) {
        // 创建工作簿对象
        XSSFWorkbook xssfWorkbook = null;
        try {
            //读取文件
            xssfWorkbook = new XSSFWorkbook(inputPath);
            //输出文件创建
            XSSFWorkbook workbook = new XSSFWorkbook();
            //输出创建工作表
            XSSFSheet sheetOut = workbook.createSheet();
            // 获取工作表 getSheet 指定sheet名字获取
            //  XSSFSheet sheet = xssfWorkbook.getSheet("sheet1");
            // 获取工作表 getSheetAt 从第一个sheet获取,一般用这个
            //XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
            //循环sheet工作表
            //新创建表的行数
            int sum = 0;
            //去掉第一列表头的标识
            int typ = 0;
            for (Sheet sheet : xssfWorkbook) {
                // 循环获取行
                int sumOne = 0;
                if (0 == tableType) {
                    typ++;
                    sumOne = 1;
                }
                if (typ == 0 && 2 == tableType) {
                    sumOne = 1;
                }
                for (Row cells : sheet) {
                    if (sumOne == 0) {
                        sumOne++;
                        continue;
                    }
                    int tableNum = 0;
                    // 创建行
                    XSSFRow row = sheetOut.createRow(sum);
                    // 获取单元格
                    for (Cell cell : cells) {
                        // 获取单元格内容 假设此时单元格内容都是文本格式，用getStringCellValue获取
                        cell.setCellType(CellType.STRING);
                        String value = cell.getStringCellValue();
                        row.createCell(tableNum).setCellValue(value);
                        tableNum++;
                    }
                    sum++;
                    sumOne++;
                }
                typ++;
            }
            xssfWorkbook.close();
            return workbook;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 输出一个execl文件
     * @param workbook XSSFWorkbook
     * @param outPath 输出文件位置（全路径）
     * @throws IOException
     */
    public static void out(XSSFWorkbook workbook,String outPath) {
        try {
            //写文件
            FileOutputStream fileOutputStream = new FileOutputStream(outPath);
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            // 释放资源
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            }catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

