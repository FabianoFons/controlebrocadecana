/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.DaoFazenda;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.FundoAgricola;

/**
 *
 * @author Fabiano
 */
@FacesConverter(value = "FazendaConverter")
public class FazendaConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            dao.DaoFazenda daoFazenda = new DaoFazenda();
            return (FundoAgricola) daoFazenda.getById(Integer.parseInt(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof FundoAgricola) {
            FundoAgricola fundoAgricola = (FundoAgricola) value;
            if (fundoAgricola != null && fundoAgricola instanceof FundoAgricola && fundoAgricola.getId() != null) {
                return fundoAgricola.getId().toString();
            }
        }
        return "";
    }
}