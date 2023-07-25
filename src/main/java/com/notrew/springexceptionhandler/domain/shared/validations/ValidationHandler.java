package com.notrew.springexceptionhandler.domain.shared.validations;

import com.notrew.springexceptionhandler.domain.shared.exceptions.Error;

import java.util.List;

public interface ValidationHandler {
    ValidationHandler append(Error err);
    ValidationHandler append(ValidationHandler validationHandler);

    <T> T validate(Validation<T> validation);

    List<Error> getErrors();

    default  boolean hasError(){
        return getErrors() != null && !getErrors().isEmpty();
    }

    default Error firstError(){
        if(getErrors() != null && !getErrors().isEmpty()){
            return  getErrors().get(0);
        }else{
            return null;
        }
    }
    interface  Validation<T>{
        T validate();
    }
}
