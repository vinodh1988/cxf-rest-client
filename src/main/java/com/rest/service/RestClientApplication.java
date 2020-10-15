package com.rest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

@SpringBootApplication
public class RestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
		
		List<Object> providers = new ArrayList<Object>();
		providers.add( new JacksonJaxbJsonProvider() );

		WebClient  client=WebClient.create("http://localhost:9999",providers);

		client = client.accept("application/json").type("application/json").path("/api/people");

		Collection<? extends Person> people=client.getCollection(Person.class);

		for(Person p:people){
		   System.out.println(p.getName());
		}
		
	}

}
