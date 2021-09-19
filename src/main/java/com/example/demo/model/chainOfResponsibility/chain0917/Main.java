package com.example.demo.model.chainOfResponsibility.chain0917;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Blog blog = new Blog();
        blog.setMsg("hello,(: this is my first blog.be caution! fuck <script>baidu.com</script>");
        FilterChain filterChain_1 = new FilterChain().addFilter(new XssFilter()).addFilter(new SensitiveFilter());
        FilterChain filterChain_2 = new FilterChain().addFilter(new URLFilter()).addFilter(new FaceFilter());
        filterChain_1.addFilter(filterChain_2);
        filterChain_1.doFilter(blog);
        System.out.println(blog);

    }
}

class FilterChain implements Filter{
    ArrayList<Filter> filters = new ArrayList<>();
    FilterChain addFilter(Filter filter){
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Blog blog){
        for (Filter filter: filters){
            if (!filter.doFilter(blog)) return false;
        }
        return true;
    }
}



interface Filter{
    boolean doFilter(Blog blog);
}

class URLFilter implements Filter{
    @Override
    public boolean doFilter(Blog blog) {
        blog.setMsg(blog.getMsg().replace("baidu.com","http://www.baidu.com"));
        return true;
    }
}

class FaceFilter implements Filter{

    @Override
    public boolean doFilter(Blog blog) {
        blog.setMsg(blog.getMsg().replace("(:","~~"));
        return true;
    }
}

class XssFilter implements Filter{

    @Override
    public boolean doFilter(Blog blog) {
        blog.setMsg(blog.getMsg().replaceAll("<script>|</script>",""));
        return true;
    }
}

class SensitiveFilter implements Filter{

    @Override
    public boolean doFilter(Blog blog) {
         blog.setMsg(blog.getMsg().replace("fuck",""));
         return false;
    }
}


class Blog{
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Blog{msg:"+ this.msg +"}";
    }
}


