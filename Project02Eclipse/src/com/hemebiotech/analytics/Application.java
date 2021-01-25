package com.hemebiotech.analytics;

import java.io.IOException;

public class Application {

	public static void main(String[] args) throws IOException {
		AnalyticsCounter data = new AnalyticsCounter("Project02Eclipse\\symptoms.txt");
		data.read();
		data.analyse();
		data.write("results.out");
	}

}
