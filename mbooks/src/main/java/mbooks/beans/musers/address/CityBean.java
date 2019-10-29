package mbooks.beans.musers.address;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public  @Data class CityBean {

    private String insee;

    private String postalCode;

    private String name;
}
