package br.ifrn.agenda.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(schema = "agenda", name = "contact")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contact")
    @SequenceGenerator(name = "seq_contact", schema = "agenda", sequenceName = "seq_contact", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;


}
