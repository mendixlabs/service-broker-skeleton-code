/* @<COPYRIGHT>@
 ==================================================
 Copyright 2022.
 Siemens Product Lifecycle Management Software Inc.
 ==================================================
 @<COPYRIGHT>@
*/
package com.siemens.broker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceBrokerApplication {

    private static final Logger logger = LogManager.getLogger(ServiceBrokerApplication.class);

    public static void main(String[] args) {
	logger.info("ServiceBrokerApplication Started");
	SpringApplication.run(ServiceBrokerApplication.class, args);
    }

}
