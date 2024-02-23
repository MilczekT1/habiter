package pl.konradboniecki.habiter.habit.definition;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HabitDefinitionRepository extends MongoRepository<HabitDefinition, UUID> {

    Page<HabitDefinition> findAllBy(Pageable pageable);
}
