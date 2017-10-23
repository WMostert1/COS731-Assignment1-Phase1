package za.co.wernerm.squekyclean.dto;

import za.co.wernerm.squekyclean.model.Post;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by werner on 2017/09/15.
 */
public class ThreadDTO {

    private long id;
    private String threadName;
    private Set<PostDTO> posts;

    public ThreadDTO(){}

    public ThreadDTO(long id, String threadName, Set<PostDTO> posts) {
        this.id = id;
        this.threadName = threadName;
        this.posts = posts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public Set<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(Set<PostDTO> posts) {
        this.posts = posts;
    }
}
