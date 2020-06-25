package com.java.activemq;

import com.java.activemq.produce.Queue_Produce;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@SpringBootTest(classes = Day08ActivemqSpringbootMqApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class Test {
    @Resource
    private Queue_Produce queue_produce;
    @org.junit.Test
    public void testSend(){
        queue_produce.produceMsg();
    }
}
