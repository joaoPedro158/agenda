package br.ifrn.agenda.model;

public record ValidationContext<T, R >(T data, R repository) {

}
