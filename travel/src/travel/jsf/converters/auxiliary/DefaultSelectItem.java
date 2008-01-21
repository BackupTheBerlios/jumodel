package travel.jsf.converters.auxiliary;

import javax.faces.model.SelectItem;

import travel.commons.Constants;

public class DefaultSelectItem extends SelectItem {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DefaultSelectItem() {
		super(new Integer(Constants.EMPTY_ID_NUMBER), Constants.EMPTY_OPTION);
	}
}
