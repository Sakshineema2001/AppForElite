package com.example.AppForElite.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "elite")
public class Elite
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "contact_no")
	private String contactNo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id")
	private State state;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	private Cities city;

	@Column(name = "approval")
	private Boolean approval = false;

	@Column(name = "description", length = 1000)
	private String description;

	@Column(name = "payment_mode")
	private String paymentMode;

	@Column(name = "date")
	private Date date;

	@OneToOne(mappedBy = "elite", cascade = CascadeType.ALL)
	@JsonManagedReference
	private BankDetails bankDetails;

	public BankDetails getBankDetails()
	{
		return bankDetails;
	}

	public void setBankDetails(BankDetails bankDetails)
	{
		this.bankDetails = bankDetails;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getPaymentMode()
	{
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode)
	{
		this.paymentMode = paymentMode;
	}

	@OneToOne
	private Course course;

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Boolean getApproval()
	{
		return approval;
	}

	public Course getCourse()
	{
		return course;
	}

	public void setCourse(Course course)
	{
		this.course = course;
	}

	public void setApproval(Boolean approval)
	{
		this.approval = approval;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getContactNo()
	{
		return contactNo;
	}

	public void setContactNo(String contactNo)
	{
		this.contactNo = contactNo;
	}

	public State getState()
	{
		return state;
	}

	public void setState(State state)
	{
		this.state = state;
	}

	public Cities getCity()
	{
		return city;
	}

	public void setCity(Cities city)
	{
		this.city = city;
	}

}
