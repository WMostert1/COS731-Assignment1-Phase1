package za.co.wernerm.squekyclean.dto;

import javax.persistence.Column;
import java.time.ZonedDateTime;

/**
 * Created by werner on 2017/09/14.
 */
public class CreatePostDTO {
    private long threadId;
    private String author;
    private String content;


    public CreatePostDTO(long threadId, String author, String content) {
        this.threadId = threadId;
        this.author = author;
        this.content = content;
    }

    public CreatePostDTO(){

    }

    public long getThreadId() {
        return threadId;
    }

    public void setThreadId(long threadId) {
        this.threadId = threadId;
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
}
