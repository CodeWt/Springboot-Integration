package com.example.demo.flink;

import com.example.demo.flink.DateSet.transformation.FlinkDistinct;
import com.example.demo.flink.DateSet.transformation.FlinkOuterJoin;
import org.junit.Test;

/**
 * input data from mysql and transform it via flink
 * then output these data to another table.
 * <p>
 * flink version : 1.3
 */
public class Test02 {
    @Test
    public void test02() throws Exception {
        FlinkDistinct.test01();
    }
    @Test
    public void test03() throws Exception {
        FlinkOuterJoin.test01();
    }
}
