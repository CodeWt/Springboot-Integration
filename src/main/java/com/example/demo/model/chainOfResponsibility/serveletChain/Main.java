package com.example.demo.model.chainOfResponsibility.serveletChain;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Request request = new Request();
        Response response = new Response();
        response.str="response : ";
        request.str = "hello ,welcome to Serverlet filterChain Blog!<script>http://www.baidu.com</script>.i hate 996 fuck !!!";

        new FilterChain().add(new XssFilter()).add(new SensitiveFilter())
                .doFilter(request,response);

        System.out.println(request.str);
        System.out.println(response.str);
    }
}



interface Filter{
    void doFilter(Request request,Response response,FilterChain filterChain);
}
class XssFilter implements Filter{

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replaceAll("<script>|</script>", " XssAttack ");
        filterChain.doFilter(request,response);
        response.str+="< XssFilter >";
    }
}

class SensitiveFilter implements Filter{

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.str=request.str.replaceAll("fuck|996","sensitive word");
        filterChain.doFilter(request,response);
        response.str+="< SensitiveFilter >";
    }
}

class FilterChain{
    int index;
    List<Filter> filters = new LinkedList();
    FilterChain add(Filter filter){
        filters.add(filter);
        return this;
    }
    void doFilter(Request request,Response response){
        if (index >= filters.size()) return;
        Filter filter = filters.get(index++);
        filter.doFilter(request,response,this);
    }

}
class Request{
    String str;
}
class Response{
    String str;
}

