package br.ifrn.agenda.service;

import br.ifrn.agenda.model.dto.ContatoDTO;
import org.springframework.stereotype.Service;

import  java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Override
    public List<ContatoDTO> getAll() {
        List<ContatoDTO> contatoDTOS = new ArrayList<ContatoDTO>();
            contatoDTOS.add(ContatoDTO.builder()
                    .nome("Joao Pedro")
                    .telefone("123456789")
                    .build());
            contatoDTOS.add(ContatoDTO.builder()
                    .nome("Maria Silva")
                    .telefone("987654321")
                    .build());
        return contatoDTOS;
    }
}
