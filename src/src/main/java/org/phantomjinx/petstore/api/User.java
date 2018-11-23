package org.phantomjinx.petstore.api;

import java.lang.Object;
import java.lang.String;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/user")
public interface User {
  /**
   * This can only be done by the logged in user.
   */
  @POST
  @Produces({"application/xml", "application/json"})
  void createUser(org.phantomjinx.petstore.api.beans.User body);

  @Path("/createWithArray")
  @POST
  @Produces({"application/xml", "application/json"})
  void createUsersWithArrayInput(List<org.phantomjinx.petstore.api.beans.User> body);

  @Path("/createWithList")
  @POST
  @Produces({"application/xml", "application/json"})
  void createUsersWithListInput(List<org.phantomjinx.petstore.api.beans.User> body);

  @Path("/login")
  @GET
  @Produces({"application/xml", "application/json"})
  String loginUser(@QueryParam("username") Object username,
      @QueryParam("password") Object password);

  @Path("/logout")
  @GET
  @Produces({"application/xml", "application/json"})
  void logoutUser();

  @Path("/{username}")
  @GET
  @Produces({"application/xml", "application/json"})
  org.phantomjinx.petstore.api.beans.User getUserByName(@PathParam("username") Object username);

  /**
   * This can only be done by the logged in user.
   */
  @Path("/{username}")
  @PUT
  @Produces({"application/xml", "application/json"})
  void updateUser(@PathParam("username") Object username,
      org.phantomjinx.petstore.api.beans.User body);

  /**
   * This can only be done by the logged in user.
   */
  @Path("/{username}")
  @DELETE
  @Produces({"application/xml", "application/json"})
  void deleteUser(@PathParam("username") Object username);
}
