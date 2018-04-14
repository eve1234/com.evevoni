package com.evevoni.qa.analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//child class implents parent method by overriding
public class RetryAnalyzer implements IRetryAnalyzer{
	
	int counter = 0;
	//how many times do i want to execute my test
	int  retryLimit=3;
	
	public boolean retry(ITestResult result) {
		if (counter < retryLimit) {
			counter++;
			return true;
		}
		
		return false; //once counter is == retryLimit get out of loop
	}

}
