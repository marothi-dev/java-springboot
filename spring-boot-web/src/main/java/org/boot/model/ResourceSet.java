
package org.boot.model;

import java.util.HashMap;
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
    "id",
    "user",
    "start_date",
    "end_date",
    "rate",
    "agreed_hours_per_month",
    "created",
    "updated",
    "project"
})
public class ResourceSet {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("user")
    private String user;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;
    @JsonProperty("rate")
    private Double rate;
    @JsonProperty("agreed_hours_per_month")
    private String agreedHoursPerMonth;
    @JsonProperty("created")
    private String created;
    @JsonProperty("updated")
    private String updated;
    @JsonProperty("project")
    private Integer project;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
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

    @JsonProperty("rate")
    public Double getRate() {
        return rate;
    }

    @JsonProperty("rate")
    public void setRate(Double rate) {
        this.rate = rate;
    }

    @JsonProperty("agreed_hours_per_month")
    public String getAgreedHoursPerMonth() {
        return agreedHoursPerMonth;
    }

    @JsonProperty("agreed_hours_per_month")
    public void setAgreedHoursPerMonth(String agreedHoursPerMonth) {
        this.agreedHoursPerMonth = agreedHoursPerMonth;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("updated")
    public String getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @JsonProperty("project")
    public Integer getProject() {
        return project;
    }

    @JsonProperty("project")
    public void setProject(Integer project) {
        this.project = project;
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
        return new HashCodeBuilder().append(id).append(user).append(startDate).append(endDate).append(rate).append(agreedHoursPerMonth).append(created).append(updated).append(project).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResourceSet) == false) {
            return false;
        }
        ResourceSet rhs = ((ResourceSet) other);
        return new EqualsBuilder().append(id, rhs.id).append(user, rhs.user).append(startDate, rhs.startDate).append(endDate, rhs.endDate).append(rate, rhs.rate).append(agreedHoursPerMonth, rhs.agreedHoursPerMonth).append(created, rhs.created).append(updated, rhs.updated).append(project, rhs.project).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
