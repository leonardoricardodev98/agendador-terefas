package com.leonardoricardo.agendadortarefas.business.mapper;

import com.leonardoricardo.agendadortarefas.business.dto.TarefasDTO;
import com.leonardoricardo.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}
