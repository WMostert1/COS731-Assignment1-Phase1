package za.co.wernerm.squekyclean.repository;

import org.springframework.data.repository.CrudRepository;
import za.co.wernerm.squekyclean.model.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
}
