package com.example.demo.regex;

public class BaseTest {
    /**
     *  精确匹配
     */
    static void test01(){
        String str = "abc";
        System.out.println("abc".matches(str));
        System.out.println("abcd".matches(str));
        System.out.println("asbc".matches(str));
        System.out.println("======特殊字符匹配======");
        String str1 = "asd\\&d";
        System.out.println("asd&d".matches(str1));
        System.out.println("========数字匹配========");
        String year = "20\\d\\d";
        System.out.println("2019".matches(year));
        System.out.println("12099".matches(year));
        System.out.println("20992".matches(year));
        System.out.println("=======中文匹配=======");
        /**
         *  如果想匹配非ASCII字符，例如中文，那就用\\u####的十六进制表示，例如：a\\u548cc匹配字符串"a和c"，中文字符和的Unicode编码是548c
         */
        String en = "a\\u548cc";
        System.out.println("a和c".matches(en));
        System.out.println();
    }

    /**
     *  模糊匹配
     */
    static void test02(){
        System.out.println("===== 它不能匹配\"ac\"、\"a&&c\"，因为.匹配一个字符且仅限一个字符=======");
        String str = "a.c";
        String str1 = "a..c";
        System.out.println("abc".matches(str));
        System.out.println("a^c".matches(str));
        System.out.println("abbc".matches(str));
        System.out.println("abbc".matches(str1));
        System.out.println("========匹配数字  \\d仅限单个数字字符=======");
        System.out.println("000d".matches("\\d\\d\\dd"));
        System.out.println("000d".matches("\\d\\dd"));
        System.out.println("==========匹配常用字符    用\\w可以匹配一个字母、数字或下划线，w的意思是word   ==========");
        System.out.println("xa3_".matches("x\\w\\w"));
        System.out.println("xa3_".matches("x\\w\\w\\w"));
        System.out.println("xa3_".matches("x\\w{3}"));
        System.out.println("=========匹配空格字符 用\\s可以匹配一个空格字符，注意空格字符不但包括空格，还包括tab字符（在Java中用\\t表示）");
        System.out.println("a b".matches("a\\sb"));
        System.out.println("a   b".matches("a\\sb"));
        System.out.println("ab".matches("a\\sb"));
    }

    /**
     *  匹配非数字
     * 用\d可以匹配一个数字，而\D则匹配一个非数字。例如，00\D可以匹配：
     *
     * "00A"，因为\D可以匹配非数字字符A；
     * "00#"，因为\D可以匹配非数字字符#。
     * 00\d可以匹配的字符串"007"，"008"等，00\D是不能匹配的。
     *
     * 类似的，\W可以匹配\w不能匹配的字符，\S可以匹配\s不能匹配的字符，这几个正好是反着来的。
     */
    static void test03(){
        System.out.println("==========取反========");
        String re1 = "2x\\D";//对应的正则是 2x\D
        System.out.println("2x3".matches(re1));
        System.out.println("2x#".matches(re1));
        System.out.println("2xc".matches(re1));
        System.out.println("=======重复匹配======");
        System.out.println("修饰符*可以匹配任意个字符，包括0个字符");
        String re2 = "A\\d*";
        System.out.println("A".matches(re2));
        System.out.println("A1".matches(re2));
        System.out.println("A23".matches(re2));
        String re3 = "A\\d+";
        System.out.println("修饰符+可以匹配至少一个字符");
        System.out.println("A".matches(re3));
        System.out.println("A2".matches(re3));
        System.out.println("A333".matches(re3));
        System.out.println("修饰符?可以匹配0个或一个字符");
        String re4 = "A\\d?";
        System.out.println("A".matches(re4));
        System.out.println("A1".matches(re4));
        System.out.println("A12".matches(re4));
        System.out.println("======修饰符{n,m=======}");
        String re5 = "A\\d{2,3}";
        System.out.println("A1".matches(re5));
        System.out.println("A12".matches(re5));
        System.out.println("A123".matches(re5));
        System.out.println("A1234".matches(re5));
    }

    /**
     *  复杂匹配
     */
    static void test04(){
        System.out.println("=====用正则表达式进行多行匹配时，我们用^表示开头，$表示结尾======");
        String re = "^A\\d{3}$";
        System.out.println("A001".matches(re));
        System.out.println("Adf001".matches(re));
        System.out.println("=========匹配指定范围========");
        /**
         *  0-9：字符0~9；
         *  a-f：字符a~f；
         *  A-F：字符A~F。
         */
        System.out.println("3".matches("[0-9a-fA-F]"));
        System.out.println("d".matches("[0-9a-fA-F]"));
        System.out.println("F".matches("[0-9a-fA-F]"));
        System.out.println("1A2b3c".matches("[0-9a-fA-F]{6}"));
        System.out.println("====不包含指定范围的字符=====");
        String re1 = "[^1-9]{3}";
        System.out.println("ass".matches(re1));
        System.out.println("1as".matches(re1));
        System.out.println("s2d".matches(re1));
        System.out.println("fg6".matches(re1));
        System.out.println("====或规则匹配=====");
        System.out.println("java".matches("java|php"));
        System.out.println("php".matches("java|php"));
        System.out.println("javaphp".matches("java|php"));
        System.out.println("phpjava".matches("java|php"));
    }
    public static void main(String[] args) {
        String re = "0\\d{2,3}\\-[1-9]\\d{6,7}";
        String arr[] = new String[]{"010-12345678","020-9999999","0755-7654321","010 12345678","A20-9999999","0755-7654.321"};
        for (String s: arr){
            System.out.println(s.matches(re));
        }
//        test04();
        System.out.println("--------------------");
        String re1 = "learn\\s((j|J)ava|(p|P)hp|(g|G)o)";
        System.out.println("learn java".matches(re1));
        System.out.println("learn Java".matches(re1));
        System.out.println("learn go".matches(re1));
        System.out.println("learn Go".matches(re1));
    }
}
