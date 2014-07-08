package com.marsapps.iautomech.web.converter;

import java.beans.PropertyEditorSupport;

public class ManufacturerPropertyEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		// TODO Auto-generated method stub
		return super.getAsText();
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		super.setAsText(text);
		System.err.println("EDITOR CALLED USING ------************> " + text);
	}
}
