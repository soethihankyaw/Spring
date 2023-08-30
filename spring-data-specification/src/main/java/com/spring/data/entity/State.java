package com.spring.data.entity;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.annotation.security.PermitAll;
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
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "state")
@NoArgsConstructor
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String region;

	@Enumerated(EnumType.STRING)
	private Type type;

	@Column(nullable = false)
	private String capital;

	private int porpulation;

	@OneToMany(mappedBy = "state", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<District> district;

	public enum Type {
		State("State"), Region("Region"), Union("Union Territory");

		private String value;

		private Type(String value) {
			this.value = value;
		}
	}
}
