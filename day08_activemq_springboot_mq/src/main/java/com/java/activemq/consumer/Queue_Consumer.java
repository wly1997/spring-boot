
package com.java.activemq.consumer;


import org.springframework.jms.annotation.JmsListener;

        import org.springframework.stereotype.Component;

        import javax.jms.JMSException;

        import javax.jms.TextMessage;

@Component
public class Queue_Consumer {
    @JmsListener(destination = "${myqueue}")
    public void recive(TextMessage textMessage) throws JMSException {
        System.out.println(textMessage.getText());
    }

}

