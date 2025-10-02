package br.ifrn.agenda.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContatoDTO {
    private String nome;
    private String telefone;
}
