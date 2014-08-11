package io.corepro.sdk.utils;

import java.net.HttpURLConnection;
import java.util.Date;

public interface ILogWriter {
	void write(Date timestamp, long threadId, String message, Object userDefinedObjectForLogging);
	void write(Date timestamp, long threadId, HttpURLConnection urlConnection, String body, Object userDefinedObjectForLogging);
    void write(Date timestamp, long threadId, Exception exception, String additionalInfo, Object userDefinedObjectForLogging);
}
