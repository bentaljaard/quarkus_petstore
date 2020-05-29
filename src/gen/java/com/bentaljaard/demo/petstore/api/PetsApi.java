package com.bentaljaard.demo.petstore.api;

import com.bentaljaard.demo.petstore.api.PetsApiService;

import com.bentaljaard.demo.petstore.models.Error;
import com.bentaljaard.demo.petstore.models.Pet;

import java.util.Map;
import java.util.List;
import com.bentaljaard.demo.petstore.api.NotFoundException;


import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.inject.Inject;

import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/pets")



/* API Description: "the pets API" */
public class PetsApi  {

    @Inject PetsApiService service;


    /*
    API Operation: Create a pet
    Response: Void.class
    
    
    Responses:
        ApiResponse(code = 201, message = "Null response", response = Void.class),
        ApiResponse(code = 200, message = "unexpected error", response = Error.class)
    */

    @POST
    
    
    @Produces({ "application/json" })

    public Response createPets(@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.createPets(securityContext);
    }

    /*
    API Operation: List all pets
    Response: Pet.class
    Return Container: List
    
    Responses:
        ApiResponse(code = 200, message = "A paged array of pets", response = Pet.class, responseContainer = "List"),
        ApiResponse(code = 200, message = "unexpected error", response = Error.class)
    */

    @GET
    
    
    @Produces({ "application/json" })

    public Response listPets(  /* @QueryParam("limit") */ Integer limit,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.listPets(limit,securityContext);
    }

    /*
    API Operation: Info for a specific pet
    Response: Pet.class
    
    
    Responses:
        ApiResponse(code = 200, message = "Expected response to a valid request", response = Pet.class),
        ApiResponse(code = 200, message = "unexpected error", response = Error.class)
    */

    @GET
    @Path("/{petId}")
    
    @Produces({ "application/json" })

    public Response showPetById( /* @PathParam("petId") */ String petId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.showPetById(petId,securityContext);
    }
}
