package za.co.wernerm.squekyclean.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.co.wernerm.squekyclean.dto.CreateThreadDTO;
import za.co.wernerm.squekyclean.dto.PostDTO;
import za.co.wernerm.squekyclean.dto.ThreadDTO;
import za.co.wernerm.squekyclean.model.Post;
import za.co.wernerm.squekyclean.repository.ThreadRepository;
import za.co.wernerm.squekyclean.model.Thread;
import za.co.wernerm.squekyclean.subscriptions.SNSSubscription;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by werner on 2017/09/13.
 */
@Controller
@RequestMapping(path="api/thread")
public class ThreadController {
    @Autowired
    ThreadRepository threadRepository;

    @Autowired
    SNSSubscription snsSubscription;

    @PostMapping
    public @ResponseBody Thread createThread(@RequestBody CreateThreadDTO createThreadDTO){
        String topicArn = snsSubscription.newTopic(createThreadDTO.getThreadName().replaceAll("[^a-zA-Z0-9]", ""));

        Thread thread = new Thread();
        thread.setPosts(new HashSet<>());
        thread.setTopicArn(topicArn);
        thread.setThreadName(createThreadDTO.getThreadName());

        return threadRepository.save(thread);
    }

    @GetMapping
    public @ResponseBody
    List<ThreadDTO> getThreads(){
         Iterable<Thread> threads = threadRepository.findAll();
         List<ThreadDTO> threadDTOs = new ArrayList<>();
         for(Thread t : threads){
             Set<PostDTO> posts = new HashSet<>();
             for(Post p : t.getPosts()){
                 posts.add(new PostDTO(p.getId(),p.getAuthor(), p.getContent(), p.getDatePosted()));
             }
             threadDTOs.add(new ThreadDTO(t.getId(),t.getThreadName(),posts));
         }
         return threadDTOs;
    }

    @GetMapping("/{id}")
    public @ResponseBody
    ThreadDTO getThread(@PathVariable(value="id") long id){
        Thread thread = threadRepository.findOne(id);

        Set<PostDTO> posts = new HashSet<>();
        for(Post p : thread.getPosts()){
            posts.add(new PostDTO(p.getId(),p.getAuthor(), p.getContent(), p.getDatePosted()));
        }
        return new ThreadDTO(thread.getId(),thread.getThreadName(),posts);
    }

}
