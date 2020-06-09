package com.example.demo.flink;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple3;
import org.junit.Test;

/**
 * https://ci.apache.org/projects/flink/flink-docs-release-1.3/
 */
public class Test01 {
    @Test
    public void test01() throws Exception {
        //设置服务运行环境
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        //定义输入数据集
        DataSet<Tuple3<String,String,Integer>> user = env.fromElements(
                new Tuple3<>("wtt","123",24),new Tuple3<>("zt","234",23),
                new Tuple3<>("wtt","123",24),new Tuple3<>("wyz","456",18)
        );
        //对数据集处理
        DataSet<Tuple3<String,String,Integer>> result = user.map((MapFunction<Tuple3<String, String, Integer>, Tuple3<String, String, Integer>>) tuple3 -> {
            //age+=1
            tuple3.f2 += 1;
            return tuple3;
        }).filter(new FilterFunction<Tuple3<String, String, Integer>>() {
            @Override
            public boolean filter(Tuple3<String, String, Integer> tuple3) throws Exception {
                if ((Integer)tuple3.getField(2) > 19){
                    return true;
                }
                return false;
            }
        });
        //输出处理后的数据集
        result.writeAsCsv("./user.csv");
        env.execute();
    }

    @Test
    public void test02(){
        com.example.demo.controller.Test.dis();
    }
}
