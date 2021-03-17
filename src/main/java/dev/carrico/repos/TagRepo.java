package dev.carrico.repos;

import dev.carrico.entities.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface TagRepo  extends CrudRepository<Tag, Integer> {

}
