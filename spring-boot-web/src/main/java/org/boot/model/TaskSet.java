
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
    "title",
    "due_date",
    "estimated_hours",
    "project",
    "project_data"
})
public class TaskSet {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("due_date")
    private String dueDate;
    @JsonProperty("estimated_hours")
    private String estimatedHours;
    @JsonProperty("project")
    private Integer project;
    @JsonProperty("project_data")
    private ProjectData projectData;
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

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("due_date")
    public String getDueDate() {
        return dueDate;
    }

    @JsonProperty("due_date")
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @JsonProperty("estimated_hours")
    public String getEstimatedHours() {
        return estimatedHours;
    }

    @JsonProperty("estimated_hours")
    public void setEstimatedHours(String estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    @JsonProperty("project")
    public Integer getProject() {
        return project;
    }

    @JsonProperty("project")
    public void setProject(Integer project) {
        this.project = project;
    }

    @JsonProperty("project_data")
    public ProjectData getProjectData() {
        return projectData;
    }

    @JsonProperty("project_data")
    public void setProjectData(ProjectData projectData) {
        this.projectData = projectData;
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
        return new HashCodeBuilder().append(id).append(title).append(dueDate).append(estimatedHours).append(project).append(projectData).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TaskSet) == false) {
            return false;
        }
        TaskSet rhs = ((TaskSet) other);
        return new EqualsBuilder().append(id, rhs.id).append(title, rhs.title).append(dueDate, rhs.dueDate).append(estimatedHours, rhs.estimatedHours).append(project, rhs.project).append(projectData, rhs.projectData).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
