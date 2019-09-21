package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.CustomerAsg;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-17T12:08:49")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, String> city;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, Integer> id;
    public static volatile SingularAttribute<Address, CustomerAsg> customer;

}