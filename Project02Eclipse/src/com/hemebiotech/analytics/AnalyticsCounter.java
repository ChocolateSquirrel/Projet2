package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/**
 * 
 * @author Marie
 *
 */
public class AnalyticsCounter {
	private ReadSymptomDataFromFile reader;
	private List<String> symptomsList = new ArrayList<String>();
	private TreeMap<String, Integer> symptomsMap = new TreeMap<String,Integer>();
	
	public AnalyticsCounter(String path) {
		reader = new ReadSymptomDataFromFile(path);
	}
	
	/**
	 * Fill symptomsList with symptoms from the reader (@see ReadSymptomDataFromFile)
	 */
	public void read() {
		symptomsList = reader.getSymptoms();
	}
	
	/**
	 * Transform a raw list of symptoms (symptomsList) into a TreeMap (symptomsMap) in which keys are sorted by natural order
	 * <ul>
	 * 		<li>key (String) : symptom</li>
	 * 		<li>value (Integer) : number of times the symptom appears in the list</li>
	 * </ul>
	 */
	public void analyse(){
		for (String symptom : symptomsList) {
			if (symptomsMap.containsKey(symptom)) {
				symptomsMap.put(symptom, symptomsMap.get(symptom)+1);
			} else {
				symptomsMap.put(symptom, 1);
			}
		}
	}
	
	/**
	 * Write into a file, on each line, "key : value" of the symptomsMap
	 * @param nameOfFile
	 */
	public void write(String nameOfFile) {
		try (FileWriter writer = new FileWriter(nameOfFile)){
			symptomsMap.forEach((key, value) -> {
				try {
					writer.write(key + " : "+ value + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
