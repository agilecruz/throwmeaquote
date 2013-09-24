package com.throwmeaquote;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
		features="src/test/resources"
		,strict=true
		//,format= {"pretty", "html:target/cucumber", "json:target/cucumber.json"}
		)
public class CukesRunner {
}