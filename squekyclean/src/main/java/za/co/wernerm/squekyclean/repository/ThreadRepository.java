package za.co.wernerm.squekyclean.repository;

import org.springframework.data.repository.CrudRepository;
import za.co.wernerm.squekyclean.model.Thread;

public interface ThreadRepository extends CrudRepository<Thread, Long> {
}
