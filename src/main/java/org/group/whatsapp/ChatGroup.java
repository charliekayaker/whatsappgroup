package org.group.whatsapp;
;
import lombok.extern.slf4j.Slf4j;
import org.group.whatsapp.repository.MessageRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Component
@Slf4j
public class ChatGroup {

    private List<MessageListener> messageListeners;

    private final List<Contact> contacts;

    private final Queue<Message> messagesQueueChatGroup;

    private final MessageRepository messageRepository;

    public ChatGroup(List<Contact> contacts,
                     LinkedList<Message> messagesQueue,
                     MessageRepository repository) {
        this.contacts = contacts;
        this.messagesQueueChatGroup = messagesQueue;
        this.messageListeners = new ArrayList<>();
        this.messageRepository = repository;
    }

    public void addContact(Contact contact){
        contacts.add(contact);
    }


    public void addMessage(Message message){
        messageRepository.save(message);
        messagesQueueChatGroup.add(message);
        notifyNewMessage(message);
    }

    private void notifyNewMessage(Message message){
        for(MessageListener m : messageListeners){
             m.action(message);
        }
    }

    public void addMessageListener(MessageListener l){
        this.messageListeners.add(l);
    }

}
