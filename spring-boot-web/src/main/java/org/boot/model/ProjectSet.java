package org.boot.model;

import java.sql.Date;

import lombok.Data;

@Data
public class ProjectSet {

	private int id;
	private String title;
	private Date due_date;
	private double estimated_hours;
	private int project;
	private ProjectData project_data;
}
