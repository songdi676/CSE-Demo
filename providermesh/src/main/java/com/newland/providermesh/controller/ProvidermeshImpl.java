package com.newland.providermesh.controller;


import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.apache.servicecomb.provider.rest.common.RestSchema;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2018-03-28T01:41:27.036Z")

@RestSchema(schemaId = "providermesh")
@RequestMapping(path = "/providermesh", produces = MediaType.APPLICATION_JSON)
public class ProvidermeshImpl {

    @Autowired
    private ProvidermeshDelegate userProvidermeshDelegate;


    @RequestMapping(value = "/helloworld",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public String helloworld( @RequestParam(value = "name", required = true) String name){

        return userProvidermeshDelegate.helloworld(name);
    }

}
