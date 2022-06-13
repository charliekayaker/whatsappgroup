package org.group.whatsapp.repository;

import lombok.extern.slf4j.Slf4j;
import org.group.whatsapp.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {


}
