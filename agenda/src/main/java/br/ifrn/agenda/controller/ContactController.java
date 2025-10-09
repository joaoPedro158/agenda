package br.ifrn.agenda.controller;

import br.ifrn.agenda.controller.rotas.RotaContatos;
import br.ifrn.agenda.controller.rotas.RotasBase;
import br.ifrn.agenda.model.dto.ContatoRecord;
import br.ifrn.agenda.service.ContactService;
import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(RotaContatos.ROOT)
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public String contactsPage() {
        return "contact";
    }

    @GetMapping(RotasBase.LIST)
    public ResponseEntity getContacts() {

        return ResponseEntity.ok(contactService.getAll());
    }

 @PostMapping(value= RotasBase.FORM,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveContacts(@RequestBody ContatoRecord contact) {

        return ResponseEntity.ok(contactService.saveContact(contact));
    }

}
