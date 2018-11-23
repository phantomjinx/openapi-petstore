package org.phantomjinx.petstore.api;

import java.lang.Object;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.phantomjinx.petstore.api.beans.Order;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/store")
public interface Store {
  /**
   * Returns a map of status codes to quantities
   */
  @Path("/inventory")
  @GET
  @Produces("application/json")
  Response getInventory();

  @Path("/order")
  @POST
  @Produces({"application/xml", "application/json"})
  Order placeOrder(Order body);

  /**
   * For valid response try integer IDs with value >= 1 and <= 10. Other values will generated exceptions
   */
  @Path("/order/{orderId}")
  @GET
  @Produces({"application/xml", "application/json"})
  Order getOrderById(@PathParam("orderId") Object orderId);

  /**
   * For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors
   */
  @Path("/order/{orderId}")
  @DELETE
  @Produces({"application/xml", "application/json"})
  void deleteOrder(@PathParam("orderId") Object orderId);
}
