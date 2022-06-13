package org.group.whatsapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.Id;
import java.util.Objects;
import java.util.Queue;

@Data
@AllArgsConstructor
public class Contact implements MessageListener {
    
    private String nickName;
    @Id
    private long id;
    private Queue<Message> messages;
    private Queue<Notification> notifications;

    @Override
    public void action(Message o) {
        messages.add(o);

        assert messages.peek() != null;
        if(!messages.peek().getTransmittedContact().equals(this.nickName))
            notifications.add(new Notification(Objects.requireNonNull(messages.poll()).getText()));
    }
}
