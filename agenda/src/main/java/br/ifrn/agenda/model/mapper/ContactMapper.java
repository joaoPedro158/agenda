package br.ifrn.agenda.model.mapper;

import br.ifrn.agenda.model.Contact;
import br.ifrn.agenda.model.dto.ContatoDTO;
import br.ifrn.agenda.model.dto.ContatoRecord;
import br.ifrn.agenda.repository.entity.ContactEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    @Mapping(target = "id", ignore = true) // Ignora o 'id' pois ele será gerado pelo banco
    ContactEntity toEntity(ContatoRecord dto);

    ContatoDTO toDTO(ContactEntity entity);

    Contact toModel(ContatoRecord contact);
}
