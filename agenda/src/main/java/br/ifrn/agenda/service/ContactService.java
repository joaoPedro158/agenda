package br.ifrn.agenda.service;

import br.ifrn.agenda.model.dto.ContatoDTO;
import br.ifrn.agenda.model.dto.ContatoRecord;

import java.util.List;

public interface ContactService {

    List<ContatoDTO> getAll();

    ContatoDTO saveContact(ContatoRecord contato);
}
