package com.bentaljaard.demo.petstore.api;

import com.bentaljaard.demo.petstore.api.*;
import com.bentaljaard.demo.petstore.models.*;


import com.bentaljaard.demo.petstore.models.Error;
import com.bentaljaard.demo.petstore.models.Pet;

import java.util.List;
import com.bentaljaard.demo.petstore.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


public interface PetsApiService {
      Response createPets(SecurityContext securityContext)
      throws NotFoundException;
      Response listPets(Integer limit,SecurityContext securityContext)
      throws NotFoundException;
      Response showPetById(String petId,SecurityContext securityContext)
      throws NotFoundException;
}
