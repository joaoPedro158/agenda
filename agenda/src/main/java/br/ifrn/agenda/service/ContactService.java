package br.ifrn.agenda.service;

import br.ifrn.agenda.model.dto.ContatoDTO;
import java.util.List;

public interface ContactService {
    List<ContatoDTO> getAll();
}
