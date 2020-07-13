package com.example.demo.flink.DateSet.transformation;

import com.example.demo.flink.entity.Coord;
import com.example.demo.flink.entity.Course;
import com.example.demo.flink.entity.User;
import com.example.demo.flink.entity.WC;
import org.apache.flink.api.common.functions.*;
import org.apache.flink.api.common.operators.Order;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.types.Row;
import org.apache.flink.util.Collector;
import scala.Tuple6;
import java.util.HashSet;
import java.util.Set;


public class TransferFunTest {
    public static void test01() throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        env.fromElements(new WC("a", 2), new WC("a", 1), new WC("b", 5), new WC("c", 12),
                new WC("a", 2), new WC("a", 1), new WC("b", 5), new WC("c", 12))
                .groupBy("word")
                .reduce(new ReduceFunction<WC>() {
                    @Override
                    public WC reduce(WC value1, WC value2) throws Exception {
                        System.out.println("6666 ==> " + value1.getWord() + "\t" + value1.getCount());
                        System.out.println("7777 ==> " + value2.getWord() + "\t" + value2.getCount());
                        return new WC(value1.getWord(), value1.getCount() + value2.getCount());
                    }
                }).map(new MapFunction<WC, Row>() {
            @Override
            public Row map(WC value) throws Exception {
                System.out.println("8888 ==> " + value.getWord() + "\t" + value.getCount());
                return Row.of(value.getWord(), value.getCount());
            }
        }).print();
        env.execute();
    }

    public static void test02() throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSet<Tuple2<Integer, String>> input = env.fromElements(
                new Tuple2<>(1, "a1"), new Tuple2<>(2, "b2"), new Tuple2<>(3, "a3"),
                new Tuple2<>(1, "a1"), new Tuple2<>(2, "a2"), new Tuple2<>(3, "b1"),
                new Tuple2<>(1, "a2"), new Tuple2<>(2, "a2"), new Tuple2<>(3, "a3")
        );
        input.groupBy(0)            // group DataSet by the first tuple field
                .reduceGroup(new GroupReduceFunction<Tuple2<Integer, String>, Tuple2<Integer, String>>() {
                    @Override
                    // apply GroupReduceFunction
                    public void reduce(Iterable<Tuple2<Integer, String>> values, Collector<Tuple2<Integer, String>> out) throws Exception {
                        Integer key = null;
                        Set<String> uniqueSet = new HashSet<>();
                        for (Tuple2 t : values) {
                            key = (Integer) t.f0;
                            uniqueSet.add((String) t.f1);
                        }
                        System.out.println("KEY Reduce==> " + key);
                        for (String s : uniqueSet) {
                            out.collect(new Tuple2<>(key, s));
                        }
                    }
                }).map(new MapFunction<Tuple2<Integer, String>, Tuple2<Integer, String>>() {
            @Override
            public Tuple2<Integer, String> map(Tuple2<Integer, String> value) throws Exception {
                System.out.println("MAP ==> " + value.f0);
                return value;
            }
        }).print();
        env.execute();
    }

    public static void test03() throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        env.fromElements(
                new Tuple2<>(1, "a1"), new Tuple2<>(2, "b2"), new Tuple2<>(3, "a3"),
                new Tuple2<>(1, "a1"), new Tuple2<>(2, "a2"), new Tuple2<>(3, "b1"),
                new Tuple2<>(1, "a2"), new Tuple2<>(2, "a2"), new Tuple2<>(3, "a2"),
                new Tuple2<>(1, "a1")
        ).groupBy(0).sortGroup(1, Order.ASCENDING)
                .reduceGroup(new GroupReduceFunction<Tuple2<Integer, String>, Tuple2<Integer, String>>() {
                    @Override
                    public void reduce(Iterable<Tuple2<Integer, String>> values, Collector<Tuple2<Integer, String>> out) throws Exception {
                        Integer key;
                        String comp = null;

                        for (Tuple2<Integer, String> t : values) {
                            key = t.f0;
                            String next = t.f1;
                            // check if strings are different
                            if (comp == null || !next.equals(comp)) {
                                out.collect(new Tuple2<Integer, String>(key, next));
                                comp = next;
                            }
                        }
                    }
                }).map(new MapFunction<Tuple2<Integer, String>, Tuple2<Integer, String>>() {
            @Override
            public Tuple2<Integer, String> map(Tuple2<Integer, String> value) throws Exception {
                return value;
            }
        }).print();
    }

    public static void test04() throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        System.out.println("--------");
        env.execute();
    }

    public static void test05() throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSet<Tuple2<String, Integer>> input = env.fromElements(new Tuple2<>("a", 1), new Tuple2<>("a", 5), new Tuple2<>("b", 1),
                new Tuple2<>("a", 1), new Tuple2<>("a", 5), new Tuple2<>("b", 1)); // The words received as input

//        input.groupBy(0) // group identical words
//                .combineGroup(new GroupCombineFunction<Tuple2<String, Integer>, Tuple2<String, Integer>>() {
//                    @Override
//                    public void combine(Iterable<Tuple2<String, Integer>> values, Collector<Tuple2<String, Integer>> out) throws Exception {
//                        String key = null;
//                        int sum = 0;
//                        for (Tuple2 t : values) {
//                            key = (String) t.f0;
//                            sum += (Integer) t.f1;
//                        }
//                        out.collect(new Tuple2<>(key, sum));
//                    }
//                }).print();
        input.groupBy(0)                              // group by words again
                .reduceGroup(new GroupReduceFunction<Tuple2<String, Integer>, Tuple2<String, Integer>>() {
                    @Override
                    public void reduce(Iterable<Tuple2<String, Integer>> values, Collector<Tuple2<String, Integer>> out) throws Exception {
                        String key = null;
                        int count = 0;

                        for (Tuple2<String, Integer> word : values) {
                            key = word.f0;
                            count += (Integer)word.f1;
                        }
                        // emit tuple with word and count
                        out.collect(new Tuple2(key, count));
                    }
                }).print();
        env.execute();
    }
    public static void test06() throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        env.fromElements(
                new User("wtt","123"),new User("zt","234"),
                new User("wth","143"),new User("wyz","834")
        ).join(env.fromElements(
                new Course("wth","yx"),new Course("wyz","ma"),
                new Course("zt","ch"),new Course("wtt","en")
        )).where("name")
                .equalTo("name")
                .map(new MapFunction<Tuple2<User, Course>, Row>() {
                    @Override
                    public Row map(Tuple2<User, Course> value) throws Exception {
                        return Row.of(value.f0.getName(),value.f0.getPass(),value.f1.claNa);
                    }
                }).print();
        env.execute();
    }

    public static void test07() throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        env.fromElements(
                new User("wtt","123"),new User("zt","234"),
                new User("wth","143"),new User("wyz","834")
        ).join(env.fromElements(
                new Course("wth","yx"),new Course("wyz","ma"),
                new Course("zt","ch"),new Course("wtt","en")
        )).where("name")
                .equalTo("name")
                .with(new JoinFunction<User, Course, Tuple3<String,String,String >>() {
                    @Override
                    public Tuple3<String, String, String> join(User first, Course second) throws Exception {
                        return new Tuple3<>(first.getName(),first.getPass(),second.claNa);
                    }
                }).print();
        env.execute();
    }
    public static void test08() throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        env.fromElements(
                new User("wtt","123",24,96),new User("zt","234",21,69),
                new User("wth","143",23,30),new User("wyz","834",22,88)
        ).join(env.fromElements(
                new Course("wth","yx"),new Course("wyz","ma"),
                new Course("zt","ch"),new Course("wtt","en")
        )).where("name")
                .equalTo("name")
                .with(new FlatJoinFunction<User, Course, Tuple3<String,String,Integer>>() {
                    @Override
                    public void join(User first, Course second, Collector<Tuple3<String,String,Integer>> out) throws Exception {
                        if (first.getGrade() > 60){
                            out.collect(new Tuple3<>(first.getName(),second.claNa,first.getGrade()));
                        }
                    }
                }).print();
        env.execute();
    }
    public static void test09() throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        env.fromElements(
                new Coord(1,2,3),new Coord(4,5,6),new Coord(7,8,9)
        ).cross(env.fromElements(
                new Coord(1,2,3),new Coord(4,5,6),new Coord(7,8,9)
        )).with(new CrossFunction<Coord,Coord, Tuple6<Integer,Integer,Integer,Integer,Integer,Integer>>() {
            @Override
            public Tuple6<Integer, Integer, Integer, Integer, Integer, Integer> cross(Coord val1, Coord val2) throws Exception {
                return new Tuple6<>(val1.id,val1.x ,val1.y,val2.id,val2.x,val2.y);
            }
        }).print();
        env.execute();
    }
    public static void test10() throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSet<Tuple2<String, Integer>> iVals = env.fromElements(
                new Tuple2<>("a",1),new Tuple2<>("b",3),new Tuple2<>("c",5),
                new Tuple2<>("a",2),new Tuple2<>("b",4),new Tuple2<>("c",6)
        );
        DataSet<Tuple2<String, Double>> dVals = env.fromElements(
                new Tuple2<>("a",1.1),new Tuple2<>("b",3.0),new Tuple2<>("c",5.0),
                new Tuple2<>("a",2.0),new Tuple2<>("b",4.0),new Tuple2<>("d",6.0)
        );
        iVals.coGroup(dVals)
                // group first DataSet on first tuple field
                .where(0)
                // group second DataSet on first tuple field
                .equalTo(0)
                // apply CoGroup function on each pair of groups
                .with(new CoGroupFunction<Tuple2<String, Integer>, Tuple2<String, Double>, Double>() {
                    @Override
                    public void coGroup(Iterable<Tuple2<String, Integer>> first, Iterable<Tuple2<String, Double>> second, Collector<Double> out) throws Exception {
                        String key1 = null;
                        String key2 = null;
                        Set<Integer> ints = new HashSet<>();
                        for (Tuple2 t : first){
                            ints.add((Integer) t.f1);
                            key1 = (String) t.f0;
                        }
                        System.out.println("6666key ==> " + key1);
                        for (Tuple2 t : second){
                            key2 = (String)t.f0;
                            for (Integer integer : ints){
                                out.collect((Double) t.f1 * integer);
                            }
                        }
                        System.out.println("7777key ==> " + key2);
                    }
                }).print();
        env.execute();
    }
//    public static void test11(){
//        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
//
//        env.execute();
//    }
}

