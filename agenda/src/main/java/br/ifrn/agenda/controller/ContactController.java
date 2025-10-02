package br.ifrn.agenda.controller;

import br.ifrn.agenda.controller.rotas.RotaContatos;
import br.ifrn.agenda.controller.rotas.RotasBases;
import br.ifrn.agenda.model.dto.ContatoDTO;
import br.ifrn.agenda.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(RotaContatos.ROOT)
@AllArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping(RotasBases.LISTA)
    public ResponseEntity getContact() {

        return ResponseEntity.ok(contactService.getAll());
    }
}
