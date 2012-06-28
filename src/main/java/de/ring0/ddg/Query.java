package de.ring0.ddg;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.ring0.ddg.datatypes.ResultCallback;
import de.ring0.ddg.datatypes.SearchResults;

/**
 * This class produces the actual search result.
 * It can be used synchronous or asynchronous depending on preference
 * For asynchronous processing a callback has to be set
 * 
 * @author Lennart Weller <lhw+github@ring0.de>
 */
public class Query implements Runnable {
	private final static String API_URL = "http://api.duckduckgo.com/";
	private final GsonBuilder _builder;
	private final Gson _gson;
	private String _query;
	private URL _url;
	private boolean _html;
	private SearchResults _results;
	private ResultCallback _callback;
	private IOException _exception;
	
	public Query() {
		_builder = new GsonBuilder();
		_builder.disableHtmlEscaping();
		_gson = _builder.create();
		_html = true;
		_results = null;
		_callback = null;
	}
	public Query(String query) throws MalformedURLException {
		this();
		setQuery(query);
	}
	/**
	 * Creates a new request URL for processing
	 * 
	 * @param query
	 * @throws MalformedURLException
	 */
	public void setQuery(String query) throws MalformedURLException {
		_query = query;
		_url = new URL(String.format("%s/?format=json&no_html=%d&q=%s", API_URL, _html ? 1 : 0, _query));
	}
	/**
	 * Returns a complete URL query used for processing
	 * 
	 * @return
	 */
	public String getQuery() {
		if(_url != null)
			return _url.getQuery();
		else
			return null;
	}
	/**
	 * Set to true if results should contain formated html content
	 * 
	 * @param html
	 */
	public void setHTML(boolean html) {
		_html = html;
	}
	/**
	 * Set callback which will be called with the returned search results
	 * or an error in case one was thrown
	 * 
	 * @param callback
	 */
	public void setCallback(ResultCallback callback) {
		_callback = callback;
	}
	/**
	 * Returns the results in case one needs them again
	 * 
	 * @return
	 */
	public SearchResults getResults() {
		return _results;
	}
	/**
	 * Called by the asynchronous execution
	 * 
	 */
	public void run() {
		try {
			if(_url == null)
				throw new IOException("No query available");
			URLConnection uc = _url.openConnection();
			_results = _gson.fromJson(new InputStreamReader(uc.getInputStream()), SearchResults.class);
			if(_results.getHeading() != null && _callback != null)
				_callback.queryCompleted(_results);
		} catch (IOException e) {
			_exception = e;
			if(_callback != null)
				_callback.failedQuery(e);
		}
	}
	/**
	 * Call for synchronous execution.
	 * Returns results or throws error in case there is one.
	 * 
	 * @return
	 * @throws IOException
	 */
	public SearchResults start() throws IOException {
		this.run();
		if(_exception != null)
			throw _exception;
		return _results;
	}
}
