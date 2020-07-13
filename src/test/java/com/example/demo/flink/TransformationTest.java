package com.example.demo.flink;

import com.example.demo.flink.DateSet.transformation.TransferFunTest;
import org.apache.flink.api.common.functions.*;
import org.apache.flink.api.common.operators.Order;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.util.Collector;
import org.junit.Test;

import static org.apache.flink.api.java.aggregation.Aggregations.*;

public class TransformationTest {
    /**
     * Map
     *
     * @throws Exception
     */
    @Test
    public void test01() throws Exception {
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        // MapFunction that adds two integer values
        DataSet<Tuple2<Integer, Integer>> intPairs = env.fromElements(new Tuple2<>(1, 1), new Tuple2<>(2, 2), new Tuple2<>(3, 3));
        DataSet<Integer> intSums = intPairs.map(new MapFunction<Tuple2<Integer, Integer>, Integer>() {
            @Override
            public Integer map(Tuple2<Integer, Integer> value) throws Exception {
                return value.f0 + value.f1;
            }
        });
        intSums.print();
        env.execute();
    }

    /**
     * FlatMap
     */
    @Test
    public void test02() throws Exception {
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSet<String> lines = env.fromElements(
                "I hello world !",
                "I hello china !"
        );
        lines.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
                for (String word : value.split(" ")) {
                    out.collect(new Tuple2<>(word, 1));
                }
            }
        }).groupBy(0).sum(1).print();
        env.execute();
    }

    /**
     * MapPartition
     */
    @Test
    public void test03() throws Exception {
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSet<String> lines = env.fromElements(
                "I hello world !",
                "I hello china !"
        );
        lines.mapPartition(new MapPartitionFunction<String, Long>() {
            @Override
            public void mapPartition(Iterable<String> values, Collector<Long> out) throws Exception {
                long c = 0;
                for (String val : values) {
                    System.out.println("val ==> " + val);
                    c++;
                }
                out.collect(c);
            }
        }).print();
        env.execute();
    }

    /**
     * Filter
     *
     * @throws Exception
     */
    @Test
    public void test04() throws Exception {
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSet<Integer> intVals = env.fromElements(-1, 0, 1, 2, 3, 4);
        intVals.filter(new FilterFunction<Integer>() {
            @Override
            public boolean filter(Integer value) throws Exception {
                if (value.intValue() > 0) {
                    return true;
                }
                return false;
            }
        }).print();
    }

    /**
     * Projection of Tuple DataSet
     */
    @Test
    public void test05() throws Exception {
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSet<Tuple3<Integer, Double, String>> in = env.fromElements(
                new Tuple3<>(1, 1.1, "a"), new Tuple3<>(2, 2.2, "b"), new Tuple3<>(3, 3.3, "c"),
                new Tuple3<>(1, 1.1, "a"), new Tuple3<>(2, 2.2, "b"), new Tuple3<>(3, 3.3, "d")
        );
        // converts Tuple3<Integer, Double, String> into Tuple2<String, Integer>
        in.project(2, 0).print();
        System.out.println("---------------");
        in.project(2, 0, 1).print();
        in.project(2, 0).distinct(0).print();
    }

    /**
     * Reduce on Grouped DataSet
     */
    @Test
    public void test06() throws Exception {
        TransferFunTest.test01();
    }

    /**
     * GroupReduce on Grouped DataSet
     * A GroupReduce transformation that is applied on a grouped DataSet calls a user-defined group-reduce function for each group.
     * The difference between this and Reduce is that the user defined function gets the whole group at once. The function is invoked with an Iterable over all elements of a group and can return an arbitrary number of result elements.
     */
    @Test
    public void test07() throws Exception {
        TransferFunTest.test02();
    }

    /**
     * GroupReduce on sorted groups
     *
     * @throws Exception
     */
    @Test
    public void test08() throws Exception {
        TransferFunTest.test03();
    }

    /**
     * Combinable GroupReduceFunctions
     *
     * @throws Exception
     */
    @Test
    public void test09() throws Exception {
        TransferFunTest.test04();
    }

    /**
     * GroupCombine on a Grouped DataSet
     *
     * @throws Exception
     */
    @Test
    public void test10() throws Exception {
        TransferFunTest.test05();
    }

    /**
     * Aggregate on Grouped Tuple DataSet
     *
     * @throws Exception
     */
    @Test
    public void test11() throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSet<Tuple3<Integer, String, Double>> input = env.fromElements(
                new Tuple3<>(1, "a", 1.0), new Tuple3<>(2, "b", 2.0), new Tuple3<>(3, "c", 3.0),
                new Tuple3<>(4, "a", 1.1), new Tuple3<>(5, "b", 2.1), new Tuple3<>(6, "c", 3.1),
                new Tuple3<>(7, "a", 1.2), new Tuple3<>(8, "b", 2.2), new Tuple3<>(9, "c", 0.9)
        );
        DataSet<Tuple3<Integer, String, Double>> output = input
                .groupBy(1)        // group DataSet on second field
                .aggregate(SUM, 0) // compute sum of the first field
                .and(MIN, 2)   // compute minimum of the third field
                .aggregate(MIN,2)
                .aggregate(MAX,2);
        output.print();
        env.execute();
    }
    @Test
    public void test12() throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        env.fromElements(
                new Tuple3<>(1,"a",1.2),new Tuple3<>(2,"b",2.1),new Tuple3<>(3,"c",3.1),
                new Tuple3<>(4,"a",1.1),new Tuple3<>(5,"b",2.2),new Tuple3<>(6,"c",3.2),
                new Tuple3<>(4,"a",1.1),new Tuple3<>(2,"b",0.2),new Tuple3<>(6,"c",3.2)
        ) .groupBy(1)   // group DataSet on second field
                .minBy(0, 2)// select tuple with minimum values for first and third field.
                .print();
        env.execute();
    }
    /**
     * Reduce on full DataSet
     * @throws Exception
     */
    @Test
    public void test13() throws Exception{
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        env.fromElements(
                1,2,3,4,5,6,7,8,9,10
        ).reduce(new ReduceFunction<Integer>() {
            @Override
            public Integer reduce(Integer value1, Integer value2) throws Exception {
                return value1 + value2;
            }
        }).print();
    }
    /**
     * Aggregate on full Tuple DataSet
     */
    @Test
    public void test14() throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        env.fromElements(
                new Tuple2<>(1,1.1),new Tuple2<>(2,2.2),new Tuple2<>(3,3.3),
                new Tuple2<>(4,4.4),new Tuple2<>(5,5.5),new Tuple2<>(6,6.6)
        ).aggregate(SUM,0)
                .and(MIN,1)
                .print();
        env.execute();
    }
    /**
     * MinBy / MaxBy on full Tuple DataSet
     * 从左到右依次比较下标值
     */
    @Test
    public void test15() throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        env.fromElements(
                new Tuple3<>(1,"a",1.1),new Tuple3<>(6,"b",2.1),new Tuple3<>(7,"c",3.1),
                new Tuple3<>(4,"d",4.1),new Tuple3<>(5,"e",5.1),new Tuple3<>(6,"f",6.1)
        ).maxBy(0,2)
                .print();
        env.execute();
    }
    /**
     * Distinct with field position keys
     */
    @Test
    public void test16() throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        env.fromElements(
                new Tuple3<>(1,"a",1.1),new Tuple3<>(6,"b",2.1),new Tuple3<>(7,"c",3.1),
                new Tuple3<>(4,"d",4.1),new Tuple3<>(5,"e",5.1),new Tuple3<>(6,"f",6.1),
                new Tuple3<>(4,"d",4.1),new Tuple3<>(5,"e",5.1),new Tuple3<>(6,"f",6.2)
        ).distinct(0,2)
                .print();
        env.execute();
    }

    /**
     * Default Join (Join into Tuple2)
     */
    @Test
    public void test17() throws Exception {
        TransferFunTest.test06();
    }
    /**
     * Join with Join Function
     */
    @Test
    public void test18() throws Exception {
        TransferFunTest.test07();
    }
    /**
     * Join with Flat-Join Function
     */
    @Test
    public void test19() throws Exception {
        TransferFunTest.test08();
    }

    /**
     * Cross with User-Defined Function
     */
    @Test
    public void test20() throws Exception {
        TransferFunTest.test09();
    }

    /**
     * CoGroup on DataSets
     */
    @Test
    public void test21() throws Exception {
        TransferFunTest.test10();
    }
    /**
     * Union
     * First-n
     */
    @Test
    public void test22() throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        env.fromElements(
                new Tuple3<>(1,"wtt",24),new Tuple3<>(1,"zt",23),
                new Tuple3<>(2,"wtt",23),new Tuple3<>(2,"zt",25),
                new Tuple3<>(3,"wtt",21),new Tuple3<>(3,"zt",22)
        ).union(env.fromElements(
                new Tuple3<>(1,"wth",19),new Tuple3<>(1,"ypw",24),
                new Tuple3<>(2,"wth",18),new Tuple3<>(2,"ypw",25)
        )).union(env.fromElements(
                new Tuple3<>(1,"wyz",19)
        )).groupBy(1)
                .sortGroup(0,Order.ASCENDING)
                .first(1)
                .print();
        env.execute();
    }

}

