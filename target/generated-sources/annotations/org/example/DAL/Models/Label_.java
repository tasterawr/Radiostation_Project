package org.example.DAL.Models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Label.class)
public abstract class Label_ {

	public static volatile SingularAttribute<Label, Date> labelCreationDate;
	public static volatile SingularAttribute<Label, Long> id;
	public static volatile SingularAttribute<Label, String> labelName;

	public static final String LABEL_CREATION_DATE = "labelCreationDate";
	public static final String ID = "id";
	public static final String LABEL_NAME = "labelName";

}

