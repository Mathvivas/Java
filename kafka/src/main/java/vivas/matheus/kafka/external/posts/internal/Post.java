package vivas.matheus.kafka.external.posts.internal;

import vivas.matheus.kafka.external.posts.Platform;

import java.util.Set;
import java.util.UUID;

public record Post(
        UUID id,
        String author,
        String content,
        Set<Platform> plataforms
) {
}
