package com.bentaljaard.demo.petstore.api.impl;

import com.bentaljaard.demo.petstore.api.*;


import com.bentaljaard.demo.petstore.models.Error;
import com.bentaljaard.demo.petstore.models.Pet;

import java.util.List;
import com.bentaljaard.demo.petstore.api.NotFoundException;

import org.eclipse.microprofile.opentracing.Traced;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Traced
@ApplicationScoped

public class PetsApiServiceImpl implements PetsApiService {
      public Response createPets(SecurityContext securityContext)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }
      public Response listPets(Integer limit,SecurityContext securityContext)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }
      public Response showPetById(String petId,SecurityContext securityContext)
      throws NotFoundException {
      // do some magic!
      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }
}
