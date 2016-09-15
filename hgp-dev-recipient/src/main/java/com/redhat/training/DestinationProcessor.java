package com.redhat.training;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class DestinationProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
		String recipientList = "";
		String fileName = (String) in.getHeader("CamelFileNameOnly");
		if (fileName.startsWith("cars")) {
			recipientList = recipientList.concat("file:cars");
		} else if (fileName.startsWith("motorcycles")) {
			recipientList = recipientList.concat("file:motorcycles");
		} else {
			recipientList = recipientList.concat("file:cars, file:motorcycles");
		} 		
		in.getHeaders().put("destination", recipientList);
	}
}
