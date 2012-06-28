package de.ring0.ddg.datatypes;

import java.util.List;

/**
 * This class represents the search results by DuckDuckGo
 * It is automatically filled by the GSON JSON-parser and therefore
 * read-only.
 * 
 * @author Lennart Weller <lhw+github@ring0.de>
 */
public class SearchResults {
	private String Abstract;
	private String AbstractText;
	private String AbstractURL;
	private String AbstractSource;
	private String Definition;
	private String DefinitionSource;
	private String DefinitionURL;
	private String Heading;
	private String Image;
	private List<Result> RelatedTopics;
	private List<Result> Results;
	private String AnswerType;
	private String Redirect;
	private Type Type;
	
	public String getAbstract() {
		return Abstract;
	}
	public String getAbstractText() {
		return AbstractText;
	}
	public String getAbstractURL() {
		return AbstractURL;
	}
	public String getAbstractSource() {
		return AbstractSource;
	}
	public boolean hasAbstract() {
		return Abstract != null && Abstract.length() != 0;
	}
	public String getDefinition() {
		return Definition;
	}
	public String getDefinitionSource() {
		return DefinitionSource;
	}
	public String getDefinitionURL() {
		return DefinitionURL;
	}
	public boolean hasDefinition() {
		return Definition != null && Definition.length() != 0;
	}
	public String getHeading() {
		return Heading;
	}
	public String getImageURL() {
		return Image;
	}
	public List<Result> getRelatedTopics() {
		return RelatedTopics;
	}
	public boolean hasRelatedTopics() {
		return RelatedTopics.size() != 0;
	}
	public List<Result> getResults() {
		return Results;
	}
	public boolean hasResults() {
		return Results.size() != 0;
	}
	public String getAnswerType() {
		return AnswerType;
	}
	public String getRedirect() {
		return Redirect;
	}
	public Type getType() {
		return Type;
	}
}
