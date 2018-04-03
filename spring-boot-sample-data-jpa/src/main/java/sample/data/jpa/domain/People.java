package sample.data.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "demo_people")
public class People implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = -4093927848930419910L;
	@Id
	@Column(name = "people_id")
	private int peopleId;
	@Column(name = "people_name")
	private String peopleName;
	@Column
	private int status;
	@Column
	private String description;

	public int getPeopleId() {
		return peopleId;
	}

	public void setPeopleId(int peopleId) {
		this.peopleId = peopleId;
	}

	public String getPeopleName() {
		return peopleName;
	}

	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "People [peopleId=" + peopleId + ", peopleName=" + peopleName + ", status=" + status + ", description="
				+ description + "]";
	}

}
