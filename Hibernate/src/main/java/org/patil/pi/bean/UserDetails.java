package org.patil.pi.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_text")
	@SequenceGenerator(name = "seq_text", sequenceName = "seq_text", allocationSize = 1)
	private int userId;

	private String firstName;

	@Embedded
	private Address homeAddress;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(column=@Column(name="OFFICE_CITY"), name="city"),
			@AttributeOverride(column=@Column(name="OFFICE_STREET"), name="street"),
			@AttributeOverride(column=@Column(name="OFFICE_STATE"), name="state"),
			@AttributeOverride(column=@Column(name="OFFICE_POSTALCODE"), name="postalcode")})
	private Address officeAddress;

	@ElementCollection
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type="long"))
	@JoinTable(name="USER_ADDRESS",
			joinColumns=@JoinColumn(name="USER_ID")
			)
	private Collection<Address> listOfAddress = new ArrayList<Address>();
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

	
	
}
