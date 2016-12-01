/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import model.AnaliseEntomologica;
import dao.DaoAnaliseEntomologica;
import dao.DaoTalhao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Talhao;

/**
 *
 * @author Fabiano
 */
@FacesConverter(value = "TalhaoConverter")
public class TalhaoConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            dao.DaoTalhao daoTalhao = new DaoTalhao();
            return (DaoTalhao) daoTalhao.getById(Integer.parseInt(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Talhao) {
            Talhao talhao = (Talhao) value;
            if (talhao instanceof Talhao && talhao.getId() != null) {
                return talhao.getId().toString();
            }
        }
        return "";
    }
}
