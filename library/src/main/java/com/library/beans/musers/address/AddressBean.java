package com.library.beans.musers.address;

import com.library.beans.musers.user.UsersBean;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
