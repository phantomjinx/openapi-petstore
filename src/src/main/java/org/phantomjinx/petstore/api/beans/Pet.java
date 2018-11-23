
package org.phantomjinx.petstore.api.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "category",
    "name",
    "photoUrls",
    "tags",
    "status"
})
public class Pet {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("category")
    private Category category;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("photoUrls")
    private List<String> photoUrls = new ArrayList<String>();
    @JsonProperty("tags")
    private List<Tag> tags = new ArrayList<Tag>();
    /**
     * pet status in the store
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("pet status in the store")
    private Pet.Status status;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("category")
    public Category getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("photoUrls")
    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("photoUrls")
    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    @JsonProperty("tags")
    public List<Tag> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     * pet status in the store
     * 
     */
    @JsonProperty("status")
    public Pet.Status getStatus() {
        return status;
    }

    /**
     * pet status in the store
     * 
     */
    @JsonProperty("status")
    public void setStatus(Pet.Status status) {
        this.status = status;
    }

    public enum Status {

        AVAILABLE("available"),
        PENDING("pending"),
        SOLD("sold");
        private final String value;
        private final static Map<String, Pet.Status> CONSTANTS = new HashMap<String, Pet.Status>();

        static {
            for (Pet.Status c: values()) {
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
        public static Pet.Status fromValue(String value) {
            Pet.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
