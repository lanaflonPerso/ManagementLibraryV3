package com.library.zuulserver.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    private String request;

    private String response;

    private Date createTime;


}
