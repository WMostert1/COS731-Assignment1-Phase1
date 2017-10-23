package za.co.wernerm.squekyclean.dto;

import java.sql.Date;

/**
 * Created by werner on 2017/09/15.
 */
public class PostDTO {
    private long id;

    private String author;
    private String content;
    private Date datePosted;

    public PostDTO(){}

    public PostDTO(long id, String author, String content, Date datePosted) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.datePosted = datePosted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
