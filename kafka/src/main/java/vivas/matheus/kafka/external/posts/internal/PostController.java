package vivas.matheus.kafka.external.posts.internal;

import vivas.matheus.kafka.external.posts.Platform;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/posts")
class PostController {

    private final PostService posts;

    PostController(PostService posts) {
        this.posts = posts;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Post create(@RequestBody CreatePostRequest request) {
        return posts.createPost(request.author(), request.content(), request.platforms());
    }

    private record CreatePostRequest(
            String author,
            String content,
            Set<Platform> platforms
    ) {}
}