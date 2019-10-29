package mbooks.beans.musers.address;


import lombok.Data;
import lombok.NoArgsConstructor;
import mbooks.beans.musers.user.UsersBean;

import java.util.List;

@NoArgsConstructor
public  @Data class AddressBean {

    private Long id;

    private Long streetNumber;

    private String complementStreetNumber;

    private String streetType;

    private String street;

    private String complementStreet;

    private String lattitude;

    private String longitude;

    private List<CityBean> cityList;

    private List<UsersBean> usersList;
}
