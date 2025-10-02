package br.ifrn.agenda.repository;

import br.ifrn.agenda.model.dto.ContatoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public  class ContactRepositoryImpl implements ContactRepository {

    private final ContactJpaRepository contactJpaRepository;

    @Override
    public List<ContatoDTO> findAll() {
        return List.of();
    }
}