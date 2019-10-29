package mbooks.beans.musers.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public  @Data class RoleBean {
    private Long id;

    private String name;


    private String wording;
}
