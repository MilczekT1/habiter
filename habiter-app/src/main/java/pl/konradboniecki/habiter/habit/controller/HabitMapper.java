package pl.konradboniecki.habiter.habit.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import pl.konradboniecki.habiter.habit.definition.HabitDefinition;
import pl.konradboniecki.habiter.openapi.dto.model.OASCreatedHabitDefinition;
import pl.konradboniecki.habiter.openapi.dto.model.OASHabitDefinition;
import pl.konradboniecki.habiter.openapi.dto.model.OASHabitDefinitionPage;
import pl.konradboniecki.habiter.openapi.dto.model.OASPaginationMetadata;

import java.util.List;

@Service
public class HabitMapper {

    public OASCreatedHabitDefinition toCreatedHabitDto(HabitDefinition habitDefinition) {
        return new OASCreatedHabitDefinition()
                .id(habitDefinition.getId())
                .name(habitDefinition.getName())
                .type(habitDefinition.getType().toString())
                .total(habitDefinition.getTotal());
    }

    public OASHabitDefinition toHabitDto(HabitDefinition habitDefinition) {
        return new OASHabitDefinition()
                .id(habitDefinition.getId())
                .name(habitDefinition.getName())
                .type(habitDefinition.getType().toString())
                .total(habitDefinition.getTotal());
    }

    public OASHabitDefinitionPage toHabitDefinitionPage(Page<HabitDefinition> page) {
        OASPaginationMetadata paginationMetadata = new OASPaginationMetadata()
                .elements(page.getNumberOfElements())
                .pageSize(page.getPageable().getPageSize())
                .page(page.getPageable().getPageNumber())
                .totalPages(page.getTotalPages())
                .totalElements((int) page.getTotalElements());
        return new OASHabitDefinitionPage()
                .items(toList(page.getContent()))
                .meta(paginationMetadata);
    }

    public List<OASHabitDefinition> toList(List<HabitDefinition> habitDefinitionList) {
        return habitDefinitionList.stream()
                .map(this::toHabitDto)
                .toList();
    }
}
