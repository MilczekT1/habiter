package pl.konradboniecki.habiter.habit.definition;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SprintDefinitionRepository extends MongoRepository<SprintDefinition, UUID> {
}
