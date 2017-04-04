
package org.boot.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pk",
    "title",
    "description",
    "start_date",
    "end_date",
    "is_billable",
    "is_active",
    "task_set",
    "resource_set"
})
public class Project {

    @JsonProperty("pk")
    private Integer pk;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;
    @JsonProperty("is_billable")
    private Boolean isBillable;
    @JsonProperty("is_active")
    private Boolean isActive;
    @JsonProperty("task_set")
    private List<TaskSet> taskSet = null;
    @JsonProperty("resource_set")
    private List<ResourceSet> resourceSet = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("pk")
    public Integer getPk() {
        return pk;
    }

    @JsonProperty("pk")
    public void setPk(Integer pk) {
        this.pk = pk;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("start_date")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("start_date")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("end_date")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("end_date")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("is_billable")
    public Boolean getIsBillable() {
        return isBillable;
    }

    @JsonProperty("is_billable")
    public void setIsBillable(Boolean isBillable) {
        this.isBillable = isBillable;
    }

    @JsonProperty("is_active")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("is_active")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("task_set")
    public List<TaskSet> getTaskSet() {
        return taskSet;
    }

    @JsonProperty("task_set")
    public void setTaskSet(List<TaskSet> taskSet) {
        this.taskSet = taskSet;
    }

    @JsonProperty("resource_set")
    public List<ResourceSet> getResourceSet() {
        return resourceSet;
    }

    @JsonProperty("resource_set")
    public void setResourceSet(List<ResourceSet> resourceSet) {
        this.resourceSet = resourceSet;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(pk).append(title).append(description).append(startDate).append(endDate).append(isBillable).append(isActive).append(taskSet).append(resourceSet).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Project) == false) {
            return false;
        }
        Project rhs = ((Project) other);
        return new EqualsBuilder().append(pk, rhs.pk).append(title, rhs.title).append(description, rhs.description).append(startDate, rhs.startDate).append(endDate, rhs.endDate).append(isBillable, rhs.isBillable).append(isActive, rhs.isActive).append(taskSet, rhs.taskSet).append(resourceSet, rhs.resourceSet).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
