package com.example.demo.redis;


import com.example.demo.redis.entity.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
public class TestRedis {

    @Autowired
    RedisTemplate redisTemplate;//默认序列化，java序列化(加一些东西)

    @Qualifier("srt")
    private StringRedisTemplate stringRedisTemplate;//直接将字面的ASCII码序列化为字节

    @Autowired
    ObjectMapper mapper;

    @Autowired
    public TestRedis(StringRedisTemplate stringRedisTemplate){
        this.stringRedisTemplate = stringRedisTemplate;
    }
    public void testRedis(){
        //高阶api
        stringRedisTemplate.opsForValue().set("hello","world");
        System.out.println(stringRedisTemplate.opsForValue().get("hello"));
        //低阶api
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.set("hello01".getBytes(StandardCharsets.UTF_8),"wutongtong".getBytes(StandardCharsets.UTF_8));
        System.out.println(new String(connection.get("hello01".getBytes(StandardCharsets.UTF_8))));
        //hash
//        HashOperations<String, Object, Object> opsForHash = stringRedisTemplate.opsForHash();
//        opsForHash.put("wyz","age","25");
//        opsForHash.put("wyz","city","beijing");
//        System.out.println(opsForHash.entries("wyz"));
        Person p = new Person();
        p.setName("zhangtian");
        p.setAge(25);
        //序列化
//        stringRedisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        Jackson2HashMapper jackson2HashMapper = new Jackson2HashMapper(mapper, false);


        stringRedisTemplate.opsForHash().putAll("person01",jackson2HashMapper.toHash(p));
        Map map = stringRedisTemplate.opsForHash().entries("person01");
        Person person = mapper.convertValue(map, Person.class);
        System.out.println(person.getName() +"\t" + person.getAge());

        //pub-sub
        stringRedisTemplate.getConnectionFactory().getConnection().subscribe(new MessageListener() {
            @Override
            public void onMessage(Message message, byte[] bytes) {
                byte[] body = message.getBody();
                System.out.println(new String(body));
            }
        },"ooxx".getBytes(StandardCharsets.UTF_8));
        while (true){
            stringRedisTemplate.convertAndSend("ooxx","hello");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
