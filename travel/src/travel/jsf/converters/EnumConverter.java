package travel.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class EnumConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) throws ConverterException {
		if (value==null) return null;
		if (value.equals("---")) return null;
		String className=value.split(";")[0];
		String enumName=value.split(";")[1];
		Enum enumm=null;
		try {
			Class enumClass=Class.forName(className);
			enumm=Enum.valueOf(enumClass, enumName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new ConverterException();
		}
		return enumm;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) throws ConverterException {
		if (value==null) return null;
		if (value instanceof Integer) return "---";
		
		return value.getClass().getName()+";"+((Enum)value).name();
	}

}
