package br.ifrn.agenda.model;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class Validation<T, R> {

    public void process(ValidationContext<T, R> context) {
        if (this.isValid(context)) {
            this.validate(context);
        }
    }

    protected abstract boolean isValid(ValidationContext<T, R> context);

    protected abstract void validate(ValidationContext<T, R> context);
}