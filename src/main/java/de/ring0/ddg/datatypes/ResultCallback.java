package de.ring0.ddg.datatypes;

import java.io.IOException;

public interface ResultCallback {
	/**
	 * Query completed successfully
	 * @param results
	 */
	public void queryCompleted(SearchResults results);
	/**
	 * An error was thrown during execution
	 * @param e
	 */
	public void failedQuery(IOException e);
}
