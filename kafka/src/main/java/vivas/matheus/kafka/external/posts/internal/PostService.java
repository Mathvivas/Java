package vivas.matheus.kafka.external.posts.internal;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vivas.matheus.kafka.external.posts.Platform;
import vivas.matheus.kafka.external.posts.PostCreated;

import java.util.Set;
import java.util.UUID;

@Service
public class PostService {

    private final ApplicationEventPublisher events;

    public PostService(ApplicationEventPublisher events) {
        this.events = events;
    }

    @Transactional
    Post createPost(String author, String content, Set<Platform> platforms) {
        var post = new Post(UUID.randomUUID(), author, content, platforms);
        events.publishEvent(new PostCreated(post.id(), post.author(), post.content(), post.plataforms()));
        return post;
    }
}
