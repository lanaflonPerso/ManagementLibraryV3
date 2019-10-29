package mbooks.beans.musers.user;


import lombok.Data;
import lombok.NoArgsConstructor;
import mbooks.beans.musers.address.AddressBean;

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
