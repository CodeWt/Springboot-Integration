package com.example.demo.flink.DateSet;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;


public class StartExam {
    public static void main(String[] args) throws Exception {
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        DataSet<String> text = env.fromElements(
                "Who's there?",
                "I think I hear them. Stand, ho! Who's there?");

        DataSet<Tuple2<String, Integer>> wordCounts = text
                .flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
                    @Override
                    public void flatMap(String line, Collector<Tuple2<String, Integer>> out) throws Exception {
                        System.out.println("6666  ==> " + line);
                        for (String word : line.split(" ")) {
                            System.out.println("7777 ===>" + word);
                            out.collect(new Tuple2<>(word, 1));
                        }
                    }
                })
                .groupBy(0)
                .sum(1);
        wordCounts.print();
        env.execute();
    }
}

