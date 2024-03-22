package pl.konradboniecki.habiter.habit.definition;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.konradboniecki.habiter.habit.HabitType;
import pl.konradboniecki.habiter.openapi.dto.model.OASHabitDefinitionCreationRequest;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HabitDefinitionService {

    final HabitDefinitionRepository habitRepository;

    public HabitDefinition createHabitDefinition(OASHabitDefinitionCreationRequest request) {
        return habitRepository.save(new HabitDefinition()
                .setId(UUID.randomUUID())
                .setName(request.getName())
                .setType(HabitType.valueOf(request.getType()))
                .setTotal(request.getTotal())
        );
    }

    public Page<HabitDefinition> getAllHabitDefinitions(final Pageable pageable) {
        return habitRepository.findAllBy(pageable);
    }

    public List<HabitDefinition> getAllHabitDefinitions() {
        return habitRepository.findAll();
    }
}
