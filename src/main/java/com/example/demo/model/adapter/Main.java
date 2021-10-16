package com.example.demo.model.adapter;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //字节流
        FileInputStream inputStream = new FileInputStream("src/main/java/com/example/demo/model/adapter/adapter.md");
        //字节流转换为字符流（adapter）
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String content = null;
        while ((content = reader.readLine())!=null&&!"".equals(content)){
            System.out.println(content);
        }


    }
}
