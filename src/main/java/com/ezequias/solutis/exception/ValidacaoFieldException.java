package com.ezequias.solutis.exception;

import org.springframework.ui.ModelMap;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ezequias
 * @project desafio-cyberpunk
 * @date 28/02/18
 */
public class ValidacaoFieldException extends Exception {

    private List<FieldError> fieldErrors = null;

    public ValidacaoFieldException(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }

    public List<ModelMap> cleanMensagem() {
        List<ModelMap> list = new ArrayList<>();
        for (FieldError error : fieldErrors) {
            if (!list.parallelStream().anyMatch(map -> map.containsValue(error.getRejectedValue()))) {
                ModelMap map = new ModelMap();
                map.put("defaultMessage", error.getDefaultMessage());
                map.put("rejectedValue", error.getRejectedValue());
                map.put("field", error.getField());
                map.put("tipo", false);
                list.add(map);
            }
        }
        return list;
    }
}
