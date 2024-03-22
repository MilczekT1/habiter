package pl.konradboniecki.habiter.habit.definition;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.konradboniecki.habiter.openapi.dto.model.OASSprintDefinitionCreationRequest;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SprintDefinitionService {

    private final SprintDefinitionRepository sprintDefinitionRepository;
    private final HabitDefinitionService habitDefinitionService;

    public SprintDefinition createSprintDefinition(OASSprintDefinitionCreationRequest creationRequest) {
        final var sprintDefinition = SprintDefinition.builder()
                .id(UUID.randomUUID())
                .firstDay(creationRequest.getFirstDay())
                .durationInDays(creationRequest.getDurationInDays())
                .habitDefinitions(habitDefinitionService.getAllHabitDefinitions())
                .build();

        return sprintDefinitionRepository.save(sprintDefinition);
    }
}
