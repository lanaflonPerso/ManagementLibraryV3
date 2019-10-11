package com.library.beans.musers.user;

import com.library.beans.musers.address.AddressBean;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
public @Data class UsersBean {
    private Long id;

    private String lastName;

    private String firstName;

    private String email;

    private String password;

    private String phone;

    private boolean active;

    private List<RoleBean> roleList;

    private AddressBean address;
}
