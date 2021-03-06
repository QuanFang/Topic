package com.sang.topic.common.util;

import com.sang.topic.common.model.support.ErrorMessage;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class ValidationUtil {
    public static List<ErrorMessage> FieldErrorsToErrorMessages(List<FieldError> fieldErrors) {
        List<ErrorMessage> errorMessages = new ArrayList<>();
        fieldErrors.forEach(
                    fieldError -> errorMessages.add(
                            new ErrorMessage(fieldError.getField(), fieldError.getDefaultMessage())));
        return errorMessages;
    }
}
