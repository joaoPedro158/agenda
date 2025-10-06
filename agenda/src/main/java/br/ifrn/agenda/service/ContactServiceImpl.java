package br.ifrn.agenda.service;

import br.ifrn.agenda.model.dto.ContatoDTO;
import br.ifrn.agenda.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import  java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Override
    public List<ContatoDTO> getAll() {
        List<ContatoDTO> contatoDTOS = contactRepository.findAll();

        return contatoDTOS;
    }
}
