package com.example.demo.regex;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchReplaceTest {
    static void test01(){
        String s = "Athe quick brown fox jumps over the lazy dog.";
        Pattern p = Pattern.compile("\\wo\\w");
        Matcher m = p.matcher(s);
        while (m.find()){
            System.out.println(s.substring(m.start(),m.end()));
        }
        System.out.println(s.indexOf(65));
        System.out.println(s.indexOf('A'));
        System.out.println("---------------");
        String s1 = "The     quick\t\t brown   fox  jumps   over the  lazy dog.";
        System.out.println(s1.replaceAll("\\s+"," "));
        System.out.println("---------------");
        System.out.println(s.replaceAll("\\s([a-z]{4})\\s","<b>$1</b>"));
    }

    /**
     *  模拟模板引擎
     */
    static void test02(){
        String templateStr = "Hello, ${name}! You are learning ${lang}!";
        Map<String,String> map = new HashMap<>();
        map.put("name","zt");
        map.put("lang","go");
        Pattern p = Pattern.compile("\\$\\{\\w+\\}");
        Matcher m = p.matcher(templateStr);
        while (m.find()){
            templateStr = templateStr.replace(templateStr.substring(m.start(),m.end()),
                    map.get(templateStr.substring(m.start()+2,m.end()-1)));
            m = p.matcher(templateStr);

        }
        System.out.println(templateStr);
    }
    public static void main(String[] args) {
        test02();
    }
}
