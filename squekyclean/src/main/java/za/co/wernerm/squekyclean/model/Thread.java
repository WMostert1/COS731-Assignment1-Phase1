package za.co.wernerm.squekyclean.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by werner on 2017/09/13.
 */

@Entity
@Table(name = "Thread")
public class Thread implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name= "threadName")
    private String threadName;

    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL)
    private Set<Post> posts;

    private String topicArn;

    public Thread(){

    }

    public Thread(long id, String threadName, Set<Post> posts, String topicArn) {
        this.id = id;
        this.threadName = threadName;
        this.posts = posts;
        this.topicArn = topicArn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getTopicArn() {
        return topicArn;
    }

    public void setTopicArn(String topicArn) {
        this.topicArn = topicArn;
    }
}
