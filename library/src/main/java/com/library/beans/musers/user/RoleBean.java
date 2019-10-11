package com.library.beans.musers.user;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public  @Data class RoleBean {
    private Long id;

    private String name;


    private String wording;
}
