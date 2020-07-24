package com.employees.formaters;

import com.employees.entities.Departement;
import java.awt.*;

import com.employees.services.DepartementService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;

public class departementFormater implements Converter<String, Departement>, PropertyEditor {

    @Override
    public Departement convert(String integer) {
        if(!integer.equals(null)) {
            try {
                Departement departement = new Departement(Long.parseLong(String.valueOf(integer)));
                return departement;
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            return null;
        }

        return null;
    }

    @Override
    public void setValue(Object value) {

    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public boolean isPaintable() {
        return false;
    }

    @Override
    public void paintValue(Graphics gfx, Rectangle box) {

    }

    @Override
    public String getJavaInitializationString() {
        return null;
    }

    @Override
    public String getAsText() {
        return null;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

    }

    @Override
    public String[] getTags() {
        return new String[0];
    }

    @Override
    public Component getCustomEditor() {
        return null;
    }

    @Override
    public boolean supportsCustomEditor() {
        return false;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {

    }
}
