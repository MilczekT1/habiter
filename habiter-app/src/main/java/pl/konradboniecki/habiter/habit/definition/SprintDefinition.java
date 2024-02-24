package pl.konradboniecki.habiter.habit.definition;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Value
@Builder
@Document
public class SprintDefinition {

    @Id
    UUID id;
    String firstDay;
    Long durationInDays;
    List<HabitDefinition> habitDefinitions;
}
