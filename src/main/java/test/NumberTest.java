package test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author GxDong
 * @createTime 2023/06/01 10:35
 * @className NumberTest
 */
public class NumberTest {

/*    public static void  main(String[] args) {
*//*        String numStr = "000.75";
        double num = Double.parseDouble(numStr);
        String percent = String.format("%.2f%%", num);
        System.out.println(percent); // 输出 "75.00%"*//*
        String a  = "6";
        System.out.println(tuu(a));

    }
    private static boolean tuu(String a){
        if(!"1".equals(a)){
            return "2".equals(a);
        }
        return true;
    }*/
public static void main(String[] args)
{
    List<String> list1 = new ArrayList<String>();
    list1.add("apple");
    list1.add("banana");
    list1.add("orange");

    List<String> list2 = new ArrayList<String>();
    list2.add("apple");
    list2.add("grape");
    list2.add("orange");
    //替换为
    Set<String> set = new HashSet<String>();
    set.addAll(list1);
    set.addAll(list2);

    //已经去重的
    List<String> commonElements = new ArrayList<String>(set);

    List<String> onlyInList1 = new ArrayList<String>(list1);
    List<String> onlyInList2 = new ArrayList<String>(list2);

    commonElements.removeAll(onlyInList1);
    commonElements.removeAll(onlyInList2);

    onlyInList1.removeAll(commonElements);
    onlyInList2.removeAll(commonElements);

    System.out.println("Common elements: " + commonElements);
    System.out.println("Elements only in list 1: " + onlyInList1);
    System.out.println("Elements only in list 2: " + onlyInList2);



}
}
