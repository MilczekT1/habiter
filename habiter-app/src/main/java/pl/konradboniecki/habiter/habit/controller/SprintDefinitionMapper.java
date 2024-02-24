package pl.konradboniecki.habiter.habit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.konradboniecki.habiter.habit.definition.SprintDefinition;
import pl.konradboniecki.habiter.openapi.dto.model.OASCreatedSprintDefinition;

@Service
@RequiredArgsConstructor
public class SprintDefinitionMapper {

    private final HabitMapper habitMapper;

    public OASCreatedSprintDefinition toCreatedSprintDefinition(SprintDefinition sprintDefinition) {
        return new OASCreatedSprintDefinition()
                .id(sprintDefinition.getId())
                .durationInDays(sprintDefinition.getDurationInDays())
                .firstDay(sprintDefinition.getFirstDay())
                .habitDefinitions(habitMapper.toList(sprintDefinition.getHabitDefinitions()));
    }

}
