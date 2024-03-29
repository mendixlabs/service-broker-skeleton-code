/* @<COPYRIGHT>@
 ==================================================
 Copyright 2022.
 Siemens Product Lifecycle Management Software Inc.
 ==================================================
 @<COPYRIGHT>@
*/
package com.siemens.broker.events;

import org.springframework.cloud.servicebroker.model.instance.CreateServiceInstanceRequest;
import org.springframework.cloud.servicebroker.model.instance.CreateServiceInstanceResponse;
import org.springframework.cloud.servicebroker.model.instance.DeleteServiceInstanceRequest;
import org.springframework.cloud.servicebroker.model.instance.DeleteServiceInstanceResponse;
import org.springframework.cloud.servicebroker.model.instance.GetLastServiceOperationRequest;
import org.springframework.cloud.servicebroker.model.instance.GetLastServiceOperationResponse;
import org.springframework.cloud.servicebroker.model.instance.UpdateServiceInstanceRequest;
import org.springframework.cloud.servicebroker.model.instance.UpdateServiceInstanceResponse;
import org.springframework.cloud.servicebroker.service.events.flows.AsyncOperationServiceInstanceCompletionFlow;
import org.springframework.cloud.servicebroker.service.events.flows.AsyncOperationServiceInstanceErrorFlow;
import org.springframework.cloud.servicebroker.service.events.flows.AsyncOperationServiceInstanceInitializationFlow;
import org.springframework.cloud.servicebroker.service.events.flows.CreateServiceInstanceCompletionFlow;
import org.springframework.cloud.servicebroker.service.events.flows.CreateServiceInstanceErrorFlow;
import org.springframework.cloud.servicebroker.service.events.flows.CreateServiceInstanceInitializationFlow;
import org.springframework.cloud.servicebroker.service.events.flows.DeleteServiceInstanceCompletionFlow;
import org.springframework.cloud.servicebroker.service.events.flows.DeleteServiceInstanceErrorFlow;
import org.springframework.cloud.servicebroker.service.events.flows.DeleteServiceInstanceInitializationFlow;
import org.springframework.cloud.servicebroker.service.events.flows.UpdateServiceInstanceCompletionFlow;
import org.springframework.cloud.servicebroker.service.events.flows.UpdateServiceInstanceErrorFlow;
import org.springframework.cloud.servicebroker.service.events.flows.UpdateServiceInstanceInitializationFlow;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Mono;

@Configuration
public class ServiceInstanceEventFlowsConfiguration {

    // Create Service Instance flows
    @Bean
    public CreateServiceInstanceInitializationFlow createServiceInstanceInitializationFlow() {
	return new CreateServiceInstanceInitializationFlow() {
	    @Override
	    public Mono<Void> initialize(CreateServiceInstanceRequest request) {
		// BEGIN USER CODE
		// do something before the instance is created
		return Mono.empty();
		// END USER CODE
	    }
	};
    }

    @Bean
    public CreateServiceInstanceCompletionFlow createServiceInstanceCompletionFlow() {
	return new CreateServiceInstanceCompletionFlow() {
	    @Override
	    public Mono<Void> complete(CreateServiceInstanceRequest request, CreateServiceInstanceResponse response) {
		// BEGIN USER CODE
		// do something after the instance is created
		return Mono.empty();
		// END USER CODE
	    }
	};
    }

    @Bean
    public CreateServiceInstanceErrorFlow createServiceInstanceErrorFlow() {
	return new CreateServiceInstanceErrorFlow() {
	    @Override
	    public Mono<Void> error(CreateServiceInstanceRequest request, Throwable t) {
		// BEGIN USER CODE
		// do something if an error occurs while creating an instance
		//
		return Mono.empty();
		// END USER CODE
	    }
	};
    }

    // Update Service Instance flows
    @Bean
    public UpdateServiceInstanceInitializationFlow updateServiceInstanceInitializationFlow() {
	return new UpdateServiceInstanceInitializationFlow() {
	    @Override
	    public Mono<Void> initialize(UpdateServiceInstanceRequest request) {
		// BEGIN USER CODE
		// do something before the instance is updated
		return Mono.empty();
		// END USER CODE
	    }
	};
    }

    @Bean
    public UpdateServiceInstanceCompletionFlow updateServiceInstanceCompletionFlow() {
	return new UpdateServiceInstanceCompletionFlow() {
	    @Override
	    public Mono<Void> complete(UpdateServiceInstanceRequest request, UpdateServiceInstanceResponse response) {

		// do something after the instance is updated
		return Mono.empty();
		// END USER CODE
	    }
	};
    }

    @Bean
    public UpdateServiceInstanceErrorFlow updateServiceInstanceErrorFlow() {
	return new UpdateServiceInstanceErrorFlow() {
	    @Override
	    public Mono<Void> error(UpdateServiceInstanceRequest request, Throwable t) {
		// BEGIN USER CODE
		// do something if an error occurs while updating an instance
		return Mono.empty();
		// END USER CODE
	    }
	};
    }

    // Delete Service Instance flows
    @Bean
    public DeleteServiceInstanceInitializationFlow deleteServiceInstanceInitializationFlow() {
	return new DeleteServiceInstanceInitializationFlow() {
	    @Override
	    public Mono<Void> initialize(DeleteServiceInstanceRequest request) {
		// BEGIN USER CODE
		// do something before the instance is deleted
		return Mono.empty();
		// END USER CODE
	    }
	};
    }

    @Bean
    public DeleteServiceInstanceCompletionFlow deleteServiceInstanceCompletionFlow() {
	return new DeleteServiceInstanceCompletionFlow() {
	    @Override
	    public Mono<Void> complete(DeleteServiceInstanceRequest request, DeleteServiceInstanceResponse response) {
		// BEGIN USER CODE
		// do something after the instance is deleted
		return Mono.empty();
		// END USER CODE
	    }
	};
    }

    @Bean
    public DeleteServiceInstanceErrorFlow deleteServiceInstanceErrorFlow() {
	return new DeleteServiceInstanceErrorFlow() {
	    @Override
	    public Mono<Void> error(DeleteServiceInstanceRequest request, Throwable t) {
		// BEGIN USER CODE
		// do something if an error occurs while deleting the instance
		return Mono.empty();
		// END USER CODE
	    }
	};
    }

    //
    // Get Last Operation flows
    //

    @Bean
    public AsyncOperationServiceInstanceInitializationFlow getLastOperationInitializationFlow() {
	return new AsyncOperationServiceInstanceInitializationFlow() {
	    @Override
	    public Mono<Void> initialize(GetLastServiceOperationRequest request) {
		// BEGIN USER CODE
		// do something before getting the last operation
		return Mono.empty();
		// END USER CODE
	    }
	};
    }

    @Bean
    public AsyncOperationServiceInstanceCompletionFlow getLastOperationCompletionFlow() {
	return new AsyncOperationServiceInstanceCompletionFlow() {
	    @Override
	    public Mono<Void> complete(GetLastServiceOperationRequest request,
		    GetLastServiceOperationResponse response) {
		// BEGIN USER CODE
		// do something after getting the last operation
		return Mono.empty();
		// END USER CODE
	    }
	};
    }

    @Bean
    public AsyncOperationServiceInstanceErrorFlow getLastOperationErrorFlow() {
	return new AsyncOperationServiceInstanceErrorFlow() {
	    @Override
	    public Mono<Void> error(GetLastServiceOperationRequest request, Throwable t) {
		// BEGIN USER CODE
		// do something if an error occurs while getting the last operation
		return Mono.empty();
		// END USER CODE
	    }
	};
    }
}
