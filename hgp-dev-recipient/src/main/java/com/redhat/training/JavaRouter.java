package com.redhat.training;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class JavaRouter {

	public static void main(String[] args) throws Exception {

		CamelContext camelContext = new DefaultCamelContext();
		camelContext.addRoutes(new JavaRouteBuilder());
		camelContext.start();
		Thread.sleep(5000);
		camelContext.stop();
	}

}
