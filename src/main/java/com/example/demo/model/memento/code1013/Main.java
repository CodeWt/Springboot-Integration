package com.example.demo.model.memento.code1013;

import java.io.*;

/**
 *
 *
 *  序列化存盘恢复
 *
 *
 */
public class Main implements Serializable {
    static File file = new File("src/main/java/com/example/demo/model/memento/code1013/per.data");
    static void saveObj(Object obj) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static Person loadObj() {
        Person person = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            try {
                person = (Person)objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return person;
    }

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);
        saveObj(person);
        person.age = 26;
        person.name = "zt";
        person.loc.street="tj";
        System.out.println(person);
        person = loadObj();
        System.out.println(person);
    }


}

class Person implements Serializable {
    String name = "zhangsan";
    int age = 25;

    /*transient*/ Location loc = new Location("bj", 2202);

    @Override
    public String toString() {
        return "{\"name\":" + name + ",\"age\":" + age + ",\"loc\":" + loc + "}";
    }

}
class Location implements Serializable{
    String street;
    int roomNo;

    public Location(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        return "{\"street\":" + street + ",\"roomNo\":" + roomNo + "}";
    }
}



