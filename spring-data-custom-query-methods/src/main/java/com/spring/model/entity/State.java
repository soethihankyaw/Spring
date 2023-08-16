package com.spring.model.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "state")
@Getter
@Setter
public class State implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Type type;

	@Column(nullable = false)
	private String region;

	@Column(nullable = false)
	private String capital;
	private int porpulation;
	
	@OneToMany(
			mappedBy = "state",
			cascade = CascadeType.PERSIST,
			orphanRemoval = true
			)
	private List<District> distict;

	public State(long id, String name, Type type, String region, String capital, int porpulation) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.region = region;
		this.capital = capital;
		this.porpulation = porpulation;
	}

	public State(String name, Type type, String region, String capital, int porpulation) {
		super();
		this.name = name;
		this.type = type;
		this.region = region;
		this.capital = capital;
		this.porpulation = porpulation;
	}

	public enum Type {
		State("State"), Region("Region"), Union("Union Territory");

		private String value;

		private Type(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}
}
