package br.ifrn.agenda.repository;

import br.ifrn.agenda.repository.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactJpaRepository extends JpaRepository<ContactEntity, Long> {

}
