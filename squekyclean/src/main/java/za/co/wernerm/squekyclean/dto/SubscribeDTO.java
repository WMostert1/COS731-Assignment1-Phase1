package za.co.wernerm.squekyclean.dto;

/**
 * Created by werner on 2017/09/15.
 */
public class SubscribeDTO {
    private long threadId;
    private String email;

    public SubscribeDTO(){}

    public SubscribeDTO(long threadId, String email) {
        this.threadId = threadId;
        this.email = email;
    }

    public long getThreadId() {
        return threadId;
    }

    public void setThreadId(long threadId) {
        this.threadId = threadId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
