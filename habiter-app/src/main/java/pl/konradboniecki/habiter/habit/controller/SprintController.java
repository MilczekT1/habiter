package pl.konradboniecki.habiter.habit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.konradboniecki.habiter.habit.definition.SprintDefinitionService;
import pl.konradboniecki.habiter.openapi.api.SprintDefinitionManagementApi;
import pl.konradboniecki.habiter.openapi.dto.model.OASCreatedSprintDefinition;
import pl.konradboniecki.habiter.openapi.dto.model.OASSprintDefinitionCreationRequest;

@RestController
@RequiredArgsConstructor
public class SprintController implements SprintDefinitionManagementApi {

    private final SprintDefinitionService sprintDefinitionService;
    private final SprintDefinitionMapper sprintDefinitionMapper;

    @Override
    public ResponseEntity<OASCreatedSprintDefinition> addSprintDefinition(OASSprintDefinitionCreationRequest oasSprintDefinitionCreationRequest) throws Exception {
        final var definition = sprintDefinitionService.createSprintDefinition(oasSprintDefinitionCreationRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(sprintDefinitionMapper.toCreatedSprintDefinition(definition));
    }
}
