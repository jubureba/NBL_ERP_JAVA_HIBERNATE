package com.cachacajambu.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * <b>Converter para CPF.</b>
 *
 * @author Dilnei Cunha
 */
@FacesConverter("cpfConverter")
public class CPFConverter implements Converter {

    /**
     * <b>Método que remove a mascara do CPF.</b>
     *
     * @param facesContext
     * @param uIcomponent
     * @param cpf
     * @return Object
     */
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIcomponent, String cpf) {
        if (cpf.trim().equals("")) {
            return null;
        } else {
            cpf = cpf.replace("-", "");
            cpf = cpf.replace(".", "");
            return cpf;
        }
    }

    /**
     * <b>Método que retorna a String do CPF.</b>
     *
     * @param facesContext
     * @param uIcomponent
     * @param object
     * @return String
     */
    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIcomponent, Object object) {
        return object.toString();
    }
}