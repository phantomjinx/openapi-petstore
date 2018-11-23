package org.phantomjinx.petstore.api;

import java.lang.Object;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.phantomjinx.petstore.api.beans.ApiResponse;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/pet")
public interface Pet {
  @PUT
  @Produces({"application/xml", "application/json"})
  @Consumes({"application/xml", "application/json"})
  void updatePet(org.phantomjinx.petstore.api.beans.Pet body);

  @POST
  @Produces({"application/xml", "application/json"})
  @Consumes({"application/xml", "application/json"})
  void addPet(org.phantomjinx.petstore.api.beans.Pet body);

  /**
   * Multiple status values can be provided with comma separated strings
   */
  @Path("/findByStatus")
  @GET
  @Produces({"application/xml", "application/json"})
  List<org.phantomjinx.petstore.api.beans.Pet> findPetsByStatus(
      @QueryParam("status") Object status);

  /**
   * Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
   */
  @Path("/findByTags")
  @GET
  @Produces({"application/xml", "application/json"})
  List<org.phantomjinx.petstore.api.beans.Pet> findPetsByTags(@QueryParam("tags") Object tags);

  /**
   * Returns a single pet
   */
  @Path("/{petId}")
  @GET
  @Produces({"application/xml", "application/json"})
  org.phantomjinx.petstore.api.beans.Pet getPetById(@PathParam("petId") Object petId);

  @Path("/{petId}")
  @POST
  @Produces({"application/xml", "application/json"})
  @Consumes("application/x-www-form-urlencoded")
  void updatePetWithForm(@PathParam("petId") Object petId, Object name, Object status);

  @Path("/{petId}")
  @DELETE
  @Produces({"application/xml", "application/json"})
  void deletePet(Object api_key, @PathParam("petId") Object petId);

  @Path("/{petId}/uploadImage")
  @POST
  @Produces("application/json")
  @Consumes("multipart/form-data")
  ApiResponse uploadFile(@PathParam("petId") Object petId, Object additionalMetadata, Object file);
}
