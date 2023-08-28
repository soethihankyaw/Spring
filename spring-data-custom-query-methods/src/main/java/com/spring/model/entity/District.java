package com.spring.model.entity;

import java.io.Serializable;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "district")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(
		name="District.findForState",
		query= """
				select d from District d where d.state.id = :stateId
				 and lower(d.name) like lower(:name) order by d.name
				""")
public class District implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(optional = false)
	private State state;
	
	@Column(nullable = false)
	private String name;
}
