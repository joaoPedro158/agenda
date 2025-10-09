package br.ifrn.agenda.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContatoDTO {

    private Long id;
    private String nome;
    private String telefone;
    private String email;
}
