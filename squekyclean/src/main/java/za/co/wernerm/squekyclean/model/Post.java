package za.co.wernerm.squekyclean.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by werner on 2017/09/13.
 */
@Entity
@Table(name = "Post")
public class Post implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "threadId")
    private Thread thread;
    private String author;
    private String content;
    @Column(name= "datePosted")
    private Date datePosted;

    public Post(){}

    public Post(long id, Thread thread, String author, String content, Date datePosted) {
        this.id = id;
        this.thread = thread;
        this.author = author;
        this.content = content;
        this.datePosted = datePosted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}
