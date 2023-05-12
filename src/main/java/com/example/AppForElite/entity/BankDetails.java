package com.example.AppForElite.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class BankDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "account_no")
	private String accountNo;

	@Column(name = "account_owner")
	private String owner;

	@Column(name = "ifsc_code")
	private String ifsc;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "elite_id", referencedColumnName = "id")
	private Elite elite;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getAccountNo()
	{
		return accountNo;
	}

	public void setAccountNo(String accountNo)
	{
		this.accountNo = accountNo;
	}

	public String getOwner()
	{
		return owner;
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}

	public String getIfsc()
	{
		return ifsc;
	}

	public void setIfsc(String ifsc)
	{
		this.ifsc = ifsc;
	}

	public Elite getElite()
	{
		return elite;
	}

	public void setElite(Elite elite)
	{
		this.elite = elite;
	}


}
