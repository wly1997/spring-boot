package com.java;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.domain.User;
import com.java.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRedisApplication.class)
public class RedisTest {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private UserRepository userRepository;
    @Test
    public void test() throws JsonProcessingException {

        //1.从Redis中获取数据 数据形式为json
        String s = redisTemplate.boundValueOps("user.findAll").get();
        if (null==s){
            List<User> users = userRepository.findAll();
            //将list装换为json格式
            ObjectMapper objectMapper =new ObjectMapper();
            String s1 = objectMapper.writeValueAsString(users);
            redisTemplate.boundValueOps("user.findAll").set(s1);
            System.out.println("========从数据库获取数据=========");
            System.out.println(s1);
        }else {
            System.out.println("=========从缓存中获取数据========");
            System.out.println(s);


        }


        System.out.println();


        //2.判断redis中是否存在数据
        //3.不存在，从mysql中查询
        //4.将数据输出
    }
}
