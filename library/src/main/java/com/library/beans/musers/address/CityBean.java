package com.library.beans.musers.address;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public  @Data class CityBean {

    private String insee;

    private String postalCode;

    private String name;
}
