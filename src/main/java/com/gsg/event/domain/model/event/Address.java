package com.gsg.event.domain.model.event;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String addrNameOrNumber;
    private String addrStreetOrLocality;
    private String addrLandMark;
    private String addrCity;
    private String addrPostalCode;


    public static class Builder
    {
        private Address address = new Address();

        public Builder withName(String name){ address.addrNameOrNumber = name; return this;}
        public Builder atStreet(String street){ address.addrStreetOrLocality = street; return this;}
        public Builder nearByLandmark(String landmark){ address.addrLandMark = landmark; return this;}
        public Builder inCity(String city){ address.addrCity = city; return this;}
        public Builder havingPostalCode(String code){ address.addrPostalCode = code; return this;}
        public Address build(){ return address;}


    }
}
