package org.group.whatsapp;

import org.group.whatsapp.repository.MessageRepository;
import org.group.whatsapp.services.GroupService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest 
{
    @Autowired
    protected GroupService groupService;

    @Autowired
    protected MessageRepository messageRepository;

    @BeforeEach
    public void setUp(){
        Contact contactTest0 = new Contact("charlie1990",
                0, new LinkedList<>(), new LinkedList<>());
        Contact contactTest1 = new Contact("charlie1991",
                1, new LinkedList<>(), new LinkedList<>());

        groupService.addContact(contactTest0);
        groupService.addContact(contactTest1);
    }

    @Test
    public void sendMessage()
    {
        Message message = new Message();
        message.setId(1234L);
        message.setHour(String.valueOf(System.currentTimeMillis()));
        message.setText("HOLA");
        message.setReceiverContact("charlie1990");
        message.setTransmittedContact("charlie1991");

        groupService.addMessage(message);

        messageRepository.save(message);
    }


}
