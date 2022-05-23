# service-broker-skeleton

## Introduction

- The `Open Service Broker API` project  defines an HTTP(S) interface between Platforms and Service Brokers. It allows `App Services Maker` to easily provide backing services to `Maker` (users) to `provision`, `gain access` to and `managing service offerings`.

- `service-broker-skeleton` provides the template for implementation of `Open Service Broker API`.

## Pre-Requisites

- Please refer to [link](/docs/OSB-API-Overview.md) for common terminologies in Open Service Broker API
 
## What is service-broker-skeleton? 

It provides skeleton for following Service Broker API implementation 

1. Advertising a catalog of their service offerings and plans

2. Provisioning (creating or updating) service instances

3. Creating bindings between a service instance and a client application

4. Deleting bindings between a service instance and a client application

5. Deprovisioning (deleting) service instances

## How do I use service-broker-skeleton? 

### 1. Clone this repository

- Use following command to clone this repository
```sh
git@ssh.gitlab.rnd.mendix.com:appservices/appserviceresourcemanager/sample-service-broker/service-broker-skeleton.git
```


### 2. Instance Service Implementation

- **Service instance** is an instantiation of a Service Offering and Service Plan. There are several methods related to service instance.

- Navigate to [InstanceService.java](/src/main/java/com/siemens/broker/service/InstanceService.java) and notice method implementation for service instance lifecycle such as create instance, update instance, delete instance etc. For example, `createServiceInstance` method to provision service instance

```java
  @Override
    public Mono<CreateServiceInstanceResponse> createServiceInstance(CreateServiceInstanceRequest request) {
	// BEGIN USER CODE
	String serviceInstanceId = request.getServiceInstanceId();
	String planId = request.getPlanId();
	Map<String, Object> parameters = request.getParameters();

	// perform the steps necessary to initiate the asynchronous provisioning of all
	// necessary resources

	String dashboardUrl = ""; /* construct a dashboard URL */
	// END USER CODE

	return Mono.just(CreateServiceInstanceResponse.builder().dashboardUrl(dashboardUrl).async(true).build());
    }

```

**NOTE -** For Service Specific Implementation user need to update code between `// BEGIN USER CODE` and `// END USER CODE`


> Mono is implementation of Reactive Streams  for asynchronous stream processing.  It is one of the type Reactor. Each event is published to subscribers while ensuring that the subscribers are never overwhelmed.  Mono - is a publisher that produces 0 to 1 value. Operations that return a single element use this type.

<details><summary>Click to expand for Reactive programming concept </summary>

* *Reactive programming* used to build asynchronous, non-blocking and event-driven applications that can easily scale.
* Reactor is a next-gen Reactive library for building non-blocking reactive applications on the JVM.
The overall idea is to operate Asynchronously with Backpressure using Publishers and Subscribers.

	Here, are several new concepts in Reactive programming. 

	* Publisher - A Publisher is a provider of a potentially unbounded number of elements.
	
	* Subscriber - A Subscriber listens to that Publisher, asking for new data. Sometimes, it's also referred to as a Consumer.

	* Backpressure - The ability of the Subscriber to let the Publisher how many requests can it handle at the time. So it's the Subscriber that is responsible for the flow of the data, not the Publisher as it just provides the data.
</details>

For more details please refer [Mono](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html)

Similarly, there are following methods to manage lifecycle on instance 

- `updateServiceInstance` - for asynchronous updation of instance  
- `deleteServiceInstance` - for asynchronous deletion of instance
- `getServiceInstance` - to  retrieve the details of the specified service instance 
- `getLastOperation` - determine the status of the operation in progress respectively.

### 3. Service Instance Binding Implementation

-  **Service Binding** - Represents the request to use a Service Instance. Service Bindings will often contain the credentials that can then be used to communicate with the Service Instance.

- Navigate to [InstanceBindingService.java](/src/main/java/com/siemens/broker/service/InstanceBindingService.java) and notice method implementation for Service Bindings lifecycle such as create binding, delete bindings etc. 

- For example, `createServiceInstanceBinding` method to create a binding for provisioned service instance

```java
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
```

**NOTE -** For Service Specific Implementation user need to update code between `// BEGIN USER CODE` and `// END USER CODE`


Similarly, there are following methods related to service bindings such as

- `deleteServiceInstanceBinding` - delete any binding  credentials

- `getServiceInstanceBinding` - to retrieve the details of the specified service binding


## References 

- [Open Service Broker Specification](https://github.com/openservicebrokerapi/servicebroker/blob/v2.14/spec.md)



