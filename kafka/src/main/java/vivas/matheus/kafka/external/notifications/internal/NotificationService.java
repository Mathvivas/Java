package vivas.matheus.kafka.external.notifications.internal;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;
import vivas.matheus.kafka.external.posts.PostCreated;

@Component
public class NotificationService {

    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

    @ApplicationModuleListener
    void on(PostCreated event) {
        log.info("Sending notification for {} to {}", event.id(), event.author());
    }
}
