package br.ifrn.agenda.repository;

import br.ifrn.agenda.model.dto.ContatoDTO;
import br.ifrn.agenda.repository.entity.ContactEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ContactRepositoryImpl implements ContactRepository {

    private final ContactJpaRepository contactJpaRepository;

    @Override
    public List<ContatoDTO> findAll() {

        return contactJpaRepository.findAll().stream().map(this::parseToDTO).collect(Collectors.toList());
    }

    @Override
    public boolean existsByNome(String nome) {
        return contactJpaRepository.existsByNome(nome);
    }

    @Override
    public boolean existsByTelefone(String telefone) {
        return contactJpaRepository.existsByTelefone(telefone);
    }

    @Override
    public boolean existsByEmail(String email) {
        return contactJpaRepository.existsByEmail(email);
    }

    @Override
    public ContactEntity save(ContactEntity entityToSave) {
        return contactJpaRepository.save(entityToSave);
    }

    private ContatoDTO parseToDTO(ContactEntity contactEntity) {
        return ContatoDTO.builder()
                .id(contactEntity.getId())
                .nome(contactEntity.getNome())
                .telefone(contactEntity.getTelefone())
                .email(contactEntity.getEmail())
                .build();
    }
}
