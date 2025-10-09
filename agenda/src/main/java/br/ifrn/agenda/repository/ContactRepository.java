package br.ifrn.agenda.repository;

import br.ifrn.agenda.model.dto.ContatoDTO;
import br.ifrn.agenda.repository.entity.ContactEntity;

import java.util.List;

public interface ContactRepository {

    List<ContatoDTO> findAll();

    boolean existsByNome(String nome);

    boolean existsByTelefone(String telefone);

    boolean existsByEmail(String email);

    ContactEntity save(ContactEntity entityToSave);
}
