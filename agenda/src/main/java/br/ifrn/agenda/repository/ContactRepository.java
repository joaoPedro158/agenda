package br.ifrn.agenda.repository;

import br.ifrn.agenda.model.dto.ContatoDTO;

import java.util.List;
public interface ContactRepository {
    List<ContatoDTO>findAll();
}
