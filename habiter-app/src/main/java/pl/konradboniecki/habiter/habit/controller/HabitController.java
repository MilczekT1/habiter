package pl.konradboniecki.habiter.habit.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.konradboniecki.habiter.habit.definition.HabitDefinitionService;
import pl.konradboniecki.habiter.openapi.api.HabitManagementApi;
import pl.konradboniecki.habiter.openapi.dto.model.OASCreatedHabit;
import pl.konradboniecki.habiter.openapi.dto.model.OASHabitCreationRequest;
import pl.konradboniecki.habiter.openapi.dto.model.OASHabitPage;

@RestController
@AllArgsConstructor
public class HabitController implements HabitManagementApi {

    private HabitDefinitionService habitDefinitionService;
    private HabitMapper habitMapper;

    @Override
    public ResponseEntity<OASCreatedHabit> addHabit(OASHabitCreationRequest request) {
        final var habitDefinition = habitDefinitionService.createHabitDefinition(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(habitMapper.toCreatedHabitDto(habitDefinition));
    }

    @Override
    public ResponseEntity<OASHabitPage> getAllHabits(Integer page, Integer limit) throws Exception {
        final var pageable = PageRequest.of(page, limit);
        final var responseBody = habitMapper.toHabitPage(habitDefinitionService.getAllHabitDefinitions(pageable));
        return ResponseEntity.status(HttpStatus.OK)
                .body(responseBody);
    }
}
