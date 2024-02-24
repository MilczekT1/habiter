package pl.konradboniecki.habiter.habit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.konradboniecki.habiter.habit.definition.HabitDefinitionService;
import pl.konradboniecki.habiter.openapi.api.HabitDefinitionManagementApi;
import pl.konradboniecki.habiter.openapi.dto.model.OASCreatedHabitDefinition;
import pl.konradboniecki.habiter.openapi.dto.model.OASHabitDefinitionCreationRequest;
import pl.konradboniecki.habiter.openapi.dto.model.OASHabitDefinitionPage;

@RestController
@RequiredArgsConstructor
public class HabitController implements HabitDefinitionManagementApi {

    private final HabitDefinitionService habitDefinitionService;
    private final HabitMapper habitMapper;

    @Override
    public ResponseEntity<OASCreatedHabitDefinition> addHabitDefinition(OASHabitDefinitionCreationRequest request) {
        final var habitDefinition = habitDefinitionService.createHabitDefinition(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(habitMapper.toCreatedHabitDto(habitDefinition));
    }

    @Override
    public ResponseEntity<OASHabitDefinitionPage> getAllHabitDefinitions(Integer page, Integer limit) throws Exception {
        final var pageable = PageRequest.of(page, limit);
        final var responseBody = habitMapper.toHabitDefinitionPage(habitDefinitionService.getAllHabitDefinitions(pageable));
        return ResponseEntity.status(HttpStatus.OK)
                .body(responseBody);
    }
}
