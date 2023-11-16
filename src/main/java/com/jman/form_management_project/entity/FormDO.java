package com.jman.form_management_project.entity;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "form")
public class FormDO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int formId;

	@NonNull
	private String displayName;

	@NonNull
	private String internalName;

	private Boolean archived=false;

	@OneToMany(mappedBy = "form",fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@ToString.Exclude
	private List<FormVersionDO> formVersions;


}
