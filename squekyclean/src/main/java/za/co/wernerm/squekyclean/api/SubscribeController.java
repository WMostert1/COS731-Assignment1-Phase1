package za.co.wernerm.squekyclean.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import za.co.wernerm.squekyclean.dto.SubscribeDTO;
import za.co.wernerm.squekyclean.repository.ThreadRepository;
import za.co.wernerm.squekyclean.subscriptions.SNSSubscription;
import za.co.wernerm.squekyclean.model.Thread;

@Controller
@RequestMapping(path="api/subscribe")
public class SubscribeController {

    @Autowired
    ThreadRepository threadRepository;

    @Autowired
    SNSSubscription snsSubscription;

    @PostMapping
    @ResponseBody
    public ResponseEntity subscribe(@RequestBody SubscribeDTO subscribeDTO){
        Thread thread = threadRepository.findOne(subscribeDTO.getThreadId());
        snsSubscription.subscribe(thread.getTopicArn(),subscribeDTO.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
