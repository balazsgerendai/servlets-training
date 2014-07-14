package com.epam.jjp.sjspt.propertyeditors;

import java.beans.PropertyEditorSupport;

import com.epam.jjp.sjspt.domain.LightSabre;

public class LightSabreEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
        String[] textParts = text.split(",");

        String name = textParts[0];
        int damage = Integer.parseInt(textParts[1].trim());

        LightSabre result = new LightSabre(name, damage);
        setValue(result);
		
	}
}
