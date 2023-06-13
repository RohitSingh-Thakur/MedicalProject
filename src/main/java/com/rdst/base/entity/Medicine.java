package com.rdst.base.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Medicine_Table")
public class Medicine {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer productCode;
	private String productName;
	private String batchNumber;
	private Integer quantity;
	private String manufacturingDate;
	private String expiryDate;
	private Double mrp;
	private String manufacturedBy;
}
