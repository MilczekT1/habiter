package pl.konradboniecki.habiter.habit.definition;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.konradboniecki.habiter.habit.HabitType;

import java.util.UUID;

@Data
@Accessors(chain = true)
@Document
public class HabitDefinition {

    @Id
    private UUID id;
    private String name;
    private HabitType type;
    private Long total;
}
