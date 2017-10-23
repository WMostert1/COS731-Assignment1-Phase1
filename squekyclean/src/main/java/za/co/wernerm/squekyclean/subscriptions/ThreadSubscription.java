package za.co.wernerm.squekyclean.subscriptions;

import za.co.wernerm.squekyclean.dto.CreatePostDTO;
import za.co.wernerm.squekyclean.model.Post;

/**
 * Created by werner on 2017/09/15.
 */
public interface ThreadSubscription {
    String newTopic(String topicName);
    void subscribe(String topicId, String email);
    void notifySubscribers(String topicId, CreatePostDTO post, String threadName);
}
