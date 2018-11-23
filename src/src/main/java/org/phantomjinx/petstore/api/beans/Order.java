
package org.phantomjinx.petstore.api.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "petId",
    "quantity",
    "shipDate",
    "status",
    "complete"
})
public class Order {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("petId")
    private Integer petId;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("shipDate")
    private Date shipDate;
    /**
     * Order Status
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("Order Status")
    private Order.Status status;
    @JsonProperty("complete")
    private Boolean complete = false;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("petId")
    public Integer getPetId() {
        return petId;
    }

    @JsonProperty("petId")
    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("shipDate")
    public Date getShipDate() {
        return shipDate;
    }

    @JsonProperty("shipDate")
    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    /**
     * Order Status
     * 
     */
    @JsonProperty("status")
    public Order.Status getStatus() {
        return status;
    }

    /**
     * Order Status
     * 
     */
    @JsonProperty("status")
    public void setStatus(Order.Status status) {
        this.status = status;
    }

    @JsonProperty("complete")
    public Boolean getComplete() {
        return complete;
    }

    @JsonProperty("complete")
    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public enum Status {

        PLACED("placed"),
        APPROVED("approved"),
        DELIVERED("delivered");
        private final String value;
        private final static Map<String, Order.Status> CONSTANTS = new HashMap<String, Order.Status>();

        static {
            for (Order.Status c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Status(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Order.Status fromValue(String value) {
            Order.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
