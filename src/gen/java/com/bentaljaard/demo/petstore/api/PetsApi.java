package com.bentaljaard.demo.petstore.api;

import com.bentaljaard.demo.petstore.models.*;
import com.bentaljaard.demo.petstore.api.PetsApiService;

import io.swagger.annotations.ApiParam;

import com.bentaljaard.demo.petstore.models.Error;
import com.bentaljaard.demo.petstore.models.Pet;

import java.util.Map;
import java.util.List;
import com.bentaljaard.demo.petstore.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.inject.Inject;

import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/pets")


@io.swagger.annotations.Api(description = "the pets API")

public class PetsApi  {

    @Inject PetsApiService service;

    @POST
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create a pet", notes = "", response = Void.class, tags={ "pets", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Null response", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    public Response createPets(@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.createPets(securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List all pets", notes = "", response = Pet.class, responseContainer = "List", tags={ "pets", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "A paged array of pets", response = Pet.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    public Response listPets(  @QueryParam("limit") Integer limit,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.listPets(limit,securityContext);
    }
    @GET
    @Path("/{petId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Info for a specific pet", notes = "", response = Pet.class, tags={ "pets", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Expected response to a valid request", response = Pet.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    public Response showPetById( @PathParam("petId") String petId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.showPetById(petId,securityContext);
    }
}
