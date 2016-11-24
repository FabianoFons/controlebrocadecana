/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.DaoVariedade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Variedade;

/**
 *
 * @author Fabiano
 */
@FacesConverter(value = "VariedadeConverter")
public class VariedadeConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            dao.DaoVariedade daoVariedade = new DaoVariedade();
            return (Variedade) daoVariedade.getById(Integer.parseInt(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Variedade) {
            Variedade fundoAgricola = (Variedade) value;
            if (fundoAgricola != null && fundoAgricola instanceof Variedade && fundoAgricola.getId() != null) {
                return fundoAgricola.getId().toString();
            }
        }
        return "";
    }
}