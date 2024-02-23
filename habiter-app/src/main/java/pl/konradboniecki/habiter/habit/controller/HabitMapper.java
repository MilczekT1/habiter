package pl.konradboniecki.habiter.habit.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import pl.konradboniecki.habiter.habit.definition.HabitDefinition;
import pl.konradboniecki.habiter.openapi.dto.model.OASCreatedHabit;
import pl.konradboniecki.habiter.openapi.dto.model.OASHabit;
import pl.konradboniecki.habiter.openapi.dto.model.OASHabitPage;
import pl.konradboniecki.habiter.openapi.dto.model.OASPaginationMetadata;

import java.util.List;

@Service
public class HabitMapper {

    public OASCreatedHabit toCreatedHabitDto(HabitDefinition habitDefinition) {
        return new OASCreatedHabit()
                .id(habitDefinition.getId())
                .name(habitDefinition.getName())
                .type(habitDefinition.getType().toString())
                .total(habitDefinition.getTotal());
    }

    public OASHabit toHabitDto(HabitDefinition habitDefinition) {
        return new OASHabit()
                .id(habitDefinition.getId())
                .name(habitDefinition.getName())
                .type(habitDefinition.getType().toString())
                .total(habitDefinition.getTotal());
    }

    public OASHabitPage toHabitPage(Page<HabitDefinition> page) {
        OASPaginationMetadata paginationMetadata = new OASPaginationMetadata()
                .elements(page.getNumberOfElements())
                .pageSize(page.getPageable().getPageSize())
                .page(page.getPageable().getPageNumber())
                .totalPages(page.getTotalPages())
                .totalElements((int) page.getTotalElements());
        return new OASHabitPage()
                .items(convertList(page.getContent()))
                .meta(paginationMetadata);
    }

    private List<OASHabit> convertList(List<HabitDefinition> habitDefinitionList) {
        return habitDefinitionList.stream()
                .map(this::toHabitDto)
                .toList();
    }
}
