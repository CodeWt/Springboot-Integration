package com.example.demo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  分组匹配
 */
public class GroupRegexTest {
    static void test01(){
        String re = "(0\\d{2,3})\\-([1-9]\\d{6,7})";
        Pattern pattern = Pattern.compile(re);
        String arr[] = new String[]{"010-12345678","020-9999999","0755-7654321","010 12345678","A20-9999999","0755-7654.321"};
        for (String s: arr){
            Matcher matcher = pattern.matcher(s);
            if (matcher.matches()){
                System.out.println(matcher.groupCount() + "\t" + matcher.group(0) + "\t" + matcher.group(1) + "\t" + matcher.group(2));
            }
        }

    }
    static void test02(){
        String re = "(\\d{2}):(\\d{2}):(\\d{2})";
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher("23:01:59");
        if (matcher.matches()){
            System.out.println(matcher.group(1) + "\t" + matcher.group(2) + "\t" + matcher.group(3));
        }
    }

    /**
     *  贪婪匹配与非贪婪匹配
     */
    static void test03(){
        Pattern p = Pattern.compile("(\\d+)(0*)");
        String[] nums = new String[]{"123","12300","123000"};
        for (String num : nums){
            Matcher m = p.matcher(num);
            if (m.matches()){
                System.out.println(m.groupCount() + "\t0:" + m.group(0) + "\t1:" + m.group(1) + "\t2:" + m.group(2));
            }
        }
        System.out.println("-------------");
        Pattern p1 = Pattern.compile("(\\d+?)(0*)");
        for (String num : nums){
            Matcher m = p1.matcher(num);
            if (m.matches()){
                System.out.println(m.groupCount() + "\t0:" + m.group(0) + "\t1:" + m.group(1) + "\t2:" + m.group(2));
            }
        }
        System.out.println("--------------");
        String numb[] = new String[]{"999","0999","1999","1"};
        Pattern p2 = Pattern.compile("(\\d??)(9*)");
        for (String num : numb){
            Matcher m = p2.matcher(num);
            if (m.matches()) {
                System.out.println(m.groupCount() + "\t0:" + m.group(0) + "\t1:" + m.group(1) + "\t2:" + m.group(2));
            }
        }


    }
    public static void main(String[] args) {
        test03();
    }
}
