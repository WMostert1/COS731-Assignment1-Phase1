package za.co.wernerm.squekyclean.subscriptions;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.*;
import org.springframework.stereotype.Service;
import za.co.wernerm.squekyclean.dto.CreatePostDTO;
import za.co.wernerm.squekyclean.model.Post;

/**
 * Created by werner on 2017/09/15.
 */
@Service
public class SNSSubscription implements ThreadSubscription {
    private AmazonSNSClient snsClient;

    public SNSSubscription(){
        snsClient = new AmazonSNSClient();
        snsClient.setRegion(Region.getRegion(Regions.EU_WEST_1));
    }

    @Override
    public String newTopic(String topicName) {
        topicName = topicName.replace(" ","");
//create a new SNS topic
        CreateTopicRequest createTopicRequest = new CreateTopicRequest(topicName);
        CreateTopicResult createTopicResult = snsClient.createTopic(createTopicRequest);
//print TopicArn
        System.out.println(createTopicResult);
//get request id for CreateTopicRequest from SNS metadata
        System.out.println("CreateTopicRequest - " + snsClient.getCachedResponseMetadata(createTopicRequest));
        return createTopicResult.getTopicArn();
    }

    @Override
    public void subscribe(String topicId, String email) {
        //subscribe to an SNS topic
        SubscribeRequest subRequest = new SubscribeRequest(topicId, "email", email);
        snsClient.subscribe(subRequest);
//get request id for SubscribeRequest from SNS metadata
        System.out.println("SubscribeRequest - " + snsClient.getCachedResponseMetadata(subRequest));
        System.out.println("Check your email and confirm subscription.");
    }

    @Override
    public void notifySubscribers(String topicId, CreatePostDTO post, String threadName) {
        //publish to an SNS topic
        String msg = "New post on thread "+threadName+" : "+post.getContent()+" - "+post.getAuthor();
        PublishRequest publishRequest = new PublishRequest(topicId, msg, threadName + " @ SquekyClean");
        PublishResult publishResult = snsClient.publish(publishRequest);
//print MessageId of message published to SNS topic
        System.out.println("MessageId - " + publishResult.getMessageId());
    }
}
