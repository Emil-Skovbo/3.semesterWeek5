package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.Address;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-17T12:08:49")
@StaticMetamodel(CustomerAsg.class)
public class CustomerAsg_ { 

    public static volatile SingularAttribute<CustomerAsg, String> firstName;
    public static volatile SingularAttribute<CustomerAsg, String> lastName;
    public static volatile ListAttribute<CustomerAsg, Address> addresses;
    public static volatile SingularAttribute<CustomerAsg, Integer> id;

}