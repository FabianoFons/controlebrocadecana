/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import model.AnaliseEntomologica;
import dao.DaoAnaliseEntomologica;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.FundoAgricola;

/**
 *
 * @author Fabiano
 */
@FacesConverter(value = "AnaliseEntomologicaConverter")
public class AnaliseEntomologicaConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            dao.DaoAnaliseEntomologica daoAnaliseEntomologica = new DaoAnaliseEntomologica();
            return (DaoAnaliseEntomologica) daoAnaliseEntomologica.getById(Integer.parseInt(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof AnaliseEntomologica) {
            AnaliseEntomologica analiseEntomologica = (AnaliseEntomologica) value;
            if (analiseEntomologica != null && analiseEntomologica instanceof AnaliseEntomologica && analiseEntomologica.getId() != null) {
                return analiseEntomologica.getId().toString();
            }
        }
        return "";
    }
}
