package br.ifrn.agenda.service;

import br.ifrn.agenda.model.Contact;
import br.ifrn.agenda.model.ValidationContactPerson;
import br.ifrn.agenda.model.ValidationContext;
import br.ifrn.agenda.model.ValidationDataContact;
import br.ifrn.agenda.model.dto.ContatoDTO;
import br.ifrn.agenda.model.dto.ContatoRecord;
import br.ifrn.agenda.model.mapper.ContactMapper;
import br.ifrn.agenda.repository.ContactRepository;
import br.ifrn.agenda.repository.entity.ContactEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper mapper;

    @Override
    public List<ContatoDTO> getAll() {

        List<ContatoDTO> contatosDTOS = contactRepository.findAll();

        return contatosDTOS;
    }

    @Override
    public ContatoDTO saveContact(ContatoRecord contact) {

        Contact contactModel = mapper.toModel(contact);

        ValidationDataContact validators = new ValidationDataContact();
        validators.addValidator(new ValidationContactPerson());

        ValidationContext context = new ValidationContext(contactModel, contactRepository);

        validators.validate(context);

        ContactEntity entityToSave = mapper.toEntity(contact);

        ContactEntity savedEntity = contactRepository.save(entityToSave);

        return mapper.toDTO(savedEntity);
    }

}
