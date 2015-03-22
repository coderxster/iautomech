package com.marsapps.iautomech.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "manufacturer", uniqueConstraints = { @UniqueConstraint(name="UNIQUE_MANUF_CONSTRAINT", columnNames = { "name" }) })
// @NamedQueries(value = { @NamedQuery(name = "findLike", query =
// "from Manufacturer where lower(name) like lower(:name) and ") })
public class Manufacturer {

	public Manufacturer() {
		super();
	}

	public Manufacturer(String name, String contactName, String contactNumber) {
		this.name = name;
		this.contactName = contactName;
		this.contactNumber = contactNumber;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "manufacturer_id")
	private Long id;

	// Do we really need a bi-directional relationship between part and
	// manufacturer???
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "manufacturer_id")
	private Set<Part> parts;

	@Column(unique = true)
	private String name;

	@Column(name = "contact_name")
	private String contactName;

	@Column(name = "contact_number")
	private String contactNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	// @Override
	// public String toString() {
	// return getId() + "|" + getName() + "|" + getContactName() + "|"
	// + getContactNumber();
	// }

	@Override
	public boolean equals(Object obj) {
		System.err.println("calling equals....: " + obj.toString());
		if (obj instanceof Manufacturer) {

			Manufacturer manuf = (Manufacturer) obj;
			System.err.println(manuf);
			System.err.println(this);
			if (manuf.getId().equals(this.getId())
					&& manuf.getName().equals(this.getName())) {
				System.err.println("Objects ARE equal....");
				return true;
			}
		}
		System.err.println("Objects NOT equal....:" + obj.toString());
		return false;
	}
}
