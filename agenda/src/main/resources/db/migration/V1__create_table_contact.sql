CREATE SCHEMA IF NOT EXISTS agenda;

CREATE SEQUENCE IF NOT EXISTS agenda.seq_contact
    INCREMENT 1
    START 1
    MINVALUE 1
    CACHE 1;

CREATE TABLE agenda.contact
(
    id       BIGINT       NOT NULL PRIMARY KEY DEFAULT nextval('agenda.seq_contact'::regclass),

    nome     VARCHAR(255) NOT NULL,

    telefone VARCHAR(20)  NOT NULL,

    email    VARCHAR(255) NOT NULL UNIQUE
);