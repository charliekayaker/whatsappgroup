package org.group.whatsapp.services;

import org.group.whatsapp.ChatGroup;
import org.group.whatsapp.Contact;
import org.group.whatsapp.Message;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    private ChatGroup chatGroup;

    public GroupService(ChatGroup chatGroup){
        this.chatGroup = chatGroup;
    }

    public void addMessage(Message message){
        chatGroup.addMessage(message);
    }

    public void addContact(Contact contact){

        chatGroup.addContact(contact);
        chatGroup.addMessageListener(contact);
    }


}
