package de.ring0.ddg.datatypes;

/**
 * Holds actual results of the search. For results as well as related topics
 * 
 * @author Lennart Weller <lhw+github@ring0.de>
 */
public class Result {
	private String Result;
	private Icon Icon;
	private String FirstURL;
	private String Text;
	
	private class Icon {
		private String URL;
		private String Height;
		private String Width;
	}
	public String getResult() {
		return Result;
	}
	public String getIconURL() {
		return Icon.URL;
	}
	public int getIconHeight() {
		if(Icon.Height.length() > 0)
			return Integer.parseInt(Icon.Height);
		else
			return 0;
	}
	public int getIconWidth() {
		if(Icon.Width.length() > 0)
			return Integer.parseInt(Icon.Width);
		else
			return 0;
	}
	public String getURL() {
		return FirstURL;
	}
	public String getText() {
		return Text;
	}
}
