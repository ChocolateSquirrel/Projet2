package com.hemebiotech.analytics;

public class Application {

	public static void main(String[] args) {
		AnalyticsCounter data = new AnalyticsCounter("Project02Eclipse\\symptoms.txt");
		data.read();
		data.analyse();
		data.write("results.out");
	}

}
