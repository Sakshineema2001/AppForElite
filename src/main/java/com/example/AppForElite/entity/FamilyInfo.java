package com.example.AppForElite.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FamilyInfo
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name= "father_name")
	private String father;

	@Column(name= "mother_name")
	private String mother;

	@Column(name = "siblings")
	private int siblingsNo;

	@Column(name="father_occupation")
	private String fatherOccupation;

	@ManyToOne
	@JoinColumn(name = "elite_id")
	private Elite elite;

	public Elite getElite()
	{
		return elite;
	}

	public void setElite(Elite elite)
	{
		this.elite = elite;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getFather()
	{
		return father;
	}

	public void setFather(String father)
	{
		this.father = father;
	}

	public String getMother()
	{
		return mother;
	}

	public void setMother(String mother)
	{
		this.mother = mother;
	}

	public int getSiblingsNo()
	{
		return siblingsNo;
	}

	public void setSiblingsNo(int siblingsNo)
	{
		this.siblingsNo = siblingsNo;
	}

	public String getFatherOccupation()
	{
		return fatherOccupation;
	}

	public void setFatherOccupation(String fatherOccupation)
	{
		this.fatherOccupation = fatherOccupation;
	}

	@Override
	public String toString()
	{
		return "FamilyInfo{" + "id=" + id + ", father='" + father + '\'' + ", mother='" + mother + '\'' + ", siblingsNo=" + siblingsNo
				+ ", fatherOccupation='" + fatherOccupation + '\'' + '}';
	}
}
