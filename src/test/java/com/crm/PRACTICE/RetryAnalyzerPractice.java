package com.crm.PRACTICE;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {
	
	@Test(retryAnalyzer = com.crm.GenericLibrary.RetryAnalyserImplementation.class)
	public void practiceRetry() {
		
		System.out.println("this is test1");
		Assert.fail();
		System.out.println("this is passed");
	}

}
