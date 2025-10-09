package br.ifrn.agenda.model;

import br.ifrn.agenda.model.dto.ContatoRecord;
import br.ifrn.agenda.repository.ContactRepository;

public class ValidationContactPerson extends Validation<Contact, ContactRepository> {

    @Override
    protected boolean isValid(ValidationContext validation) {
        return true;
    }

    @Override
    protected void validate(ValidationContext<Contact, ContactRepository> validation) {

        Contact contact = validation.data();
        ContactRepository repository = validation.repository();

        if (repository.existsByNome(contact.getNome())) {
            throw new IllegalArgumentException("Já existe um contato cadastrado com este nome.");
        }
        if (repository.existsByTelefone(contact.getTelefone())) {
            throw new IllegalArgumentException("Já existe um contato cadastrado com este telefone.");
        }
        if (repository.existsByEmail(contact.getEmail())) {
            throw new IllegalArgumentException("Já existe um contato cadastrado com este e-mail.");
        }
    }
}
