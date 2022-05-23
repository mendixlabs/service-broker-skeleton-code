/* @<COPYRIGHT>@
 ==================================================
 Copyright 2022.
 Siemens Product Lifecycle Management Software Inc.
 ==================================================
 @<COPYRIGHT>@
*/
package com.siemens.broker.service;

import org.springframework.cloud.servicebroker.model.binding.CreateServiceInstanceAppBindingResponse;
import org.springframework.cloud.servicebroker.model.binding.CreateServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.model.binding.CreateServiceInstanceBindingResponse;
import org.springframework.cloud.servicebroker.model.binding.DeleteServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.model.binding.DeleteServiceInstanceBindingResponse;
import org.springframework.cloud.servicebroker.model.binding.GetServiceInstanceAppBindingResponse;
import org.springframework.cloud.servicebroker.model.binding.GetServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.model.binding.GetServiceInstanceBindingResponse;
import org.springframework.cloud.servicebroker.service.ServiceInstanceBindingService;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class InstanceBindingService implements ServiceInstanceBindingService {

    @Override
    public Mono<CreateServiceInstanceBindingResponse> createServiceInstanceBinding(
	    CreateServiceInstanceBindingRequest request) {

	// BEGIN USER CODE
	String serviceInstanceId = request.getServiceInstanceId();
	String bindingId = request.getBindingId();

	// create credentials and store for later retrieval

	String url = new String(/* build a URL to access the service instance */);
	String bindingUsername = new String(/* create a user */);
	String bindingPassword = new String(/* create a password */);

	CreateServiceInstanceBindingResponse response = CreateServiceInstanceAppBindingResponse.builder()
		.credentials("url", url).credentials("username", bindingUsername)
		.credentials("password", bindingPassword).bindingExisted(false).async(true).build();

	// END USER CODE
	return Mono.just(response);
    }

    @Override
    public Mono<DeleteServiceInstanceBindingResponse> deleteServiceInstanceBinding(
	    DeleteServiceInstanceBindingRequest request) {
	String serviceInstanceId = request.getServiceInstanceId();
	String bindingId = request.getBindingId();

	// BEGIN USER CODE
	
	// delete any binding-specific credentials

	// END USER CODE
	
	return Mono.just(DeleteServiceInstanceBindingResponse.builder().async(true).build());
    }

    @Override
    public Mono<GetServiceInstanceBindingResponse> getServiceInstanceBinding(GetServiceInstanceBindingRequest request) {
	// BEGIN USER CODE
	String serviceInstanceId = request.getServiceInstanceId();
	String bindingId = request.getBindingId();

	// retrieve the details of the specified service binding

	String url = new String(/* retrieved URL */);
	String bindingUsername = new String(/* retrieved user */);
	String bindingPassword = new String(/* retrieved password */);

	GetServiceInstanceBindingResponse response = GetServiceInstanceAppBindingResponse.builder()
		.credentials("username", bindingUsername).credentials("password", bindingPassword)
		.credentials("url", url).build();

	// END USER CODE
	return Mono.just(response);
    }
}
