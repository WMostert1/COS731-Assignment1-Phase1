package za.co.wernerm.squekyclean.dto;

/**
 * Created by werner on 2017/09/13.
 */
public class CreateThreadDTO {
    private String threadName;

    public CreateThreadDTO(String threadName) {
        this.threadName = threadName;
    }

    public CreateThreadDTO(){

    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }
}
