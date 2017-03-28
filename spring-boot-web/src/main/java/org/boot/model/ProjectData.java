package org.boot.model;

import java.util.Date;

import lombok.Data;

@Data
public class ProjectData {
	private int pk;
	private String title;
	private String description;
	private Date start_date;
	private Date end_date;
	private boolean billable;
	private boolean active;
}
