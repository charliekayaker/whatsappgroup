package org.group.whatsapp.controller;

import org.group.whatsapp.services.GroupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chatgroup")
public class ChatGroupController {

    private GroupService messageService;

    public ChatGroupController(GroupService messageService){
        this.messageService = messageService;
    }


    public void anything(){

    }

}
