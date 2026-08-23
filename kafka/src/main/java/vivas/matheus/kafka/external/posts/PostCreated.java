package vivas.matheus.kafka.external.posts;

import org.springframework.modulith.events.Externalized;

import java.util.Set;
import java.util.UUID;

@Externalized("social-posts::#{#this.id()}")
public record PostCreated(
        UUID id,
        String author,
        String content,
        Set<Platform> platforms
) {
}
