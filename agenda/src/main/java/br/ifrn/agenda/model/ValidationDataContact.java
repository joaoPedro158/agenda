package br.ifrn.agenda.model;

import java.util.ArrayList;
import java.util.List;

public class ValidationDataContact {

    private final List<Validation> validators = new ArrayList<>();

    public void addValidator(Validation validator) {this.validators.add(validator);}

    public void validate(ValidationContext validation) {
        this.validators.forEach(o -> {
            o.process(validation);
        });
    }

}
