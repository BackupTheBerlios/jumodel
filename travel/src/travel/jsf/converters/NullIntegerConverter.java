package travel.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.IntegerConverter;

import travel.commons.Constants;

public class NullIntegerConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value)
			throws ConverterException {
		Object result = null;
		if (value != null) {
			value=value.trim();
			if ("".equals(value)) return null;
			if (value.equals(Constants.EMPTY_ID_NUMBER)) return null;
			
			IntegerConverter stdCnvrt=new IntegerConverter();
			result=stdCnvrt.getAsObject(context, component, value);
		}
		return result;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value)
			throws ConverterException {
		if (value==null) return null;
		return ((Integer)value).toString();
	}

}
