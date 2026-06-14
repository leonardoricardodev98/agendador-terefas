package com.leonardoricardo.agendadortarefas.business;


import com.leonardoricardo.agendadortarefas.business.dto.TarefasDTO;
import com.leonardoricardo.agendadortarefas.business.mapper.TarefasConverter;
import com.leonardoricardo.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.leonardoricardo.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.leonardoricardo.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.leonardoricardo.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){

        String email = jwtUtil.extrairEmailToken(token.substring(7));

        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);


        return tarefaConverter.paraTarefaDTO(
                tarefasRepository.save(entity));
    }
}
