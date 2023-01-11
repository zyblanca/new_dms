package com.example.dms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

/**
 * @author zhouy
 * @date 2021/10/24
 * good 10
 */
@Data
public class User {
    @XmlAttribute(name = "id")
    private Long id;
    @XmlElement(name = "NAME")
    private String name;
    @XmlElement(name = "PHONE")
    private String phone;
    @XmlElement(name = "EMAIL")
    private String email;
    @XmlElement(name = "PASS_WORD")
    private String password;
    @XmlElement(name = "CITY_ID")
    private Integer cityId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    private Integer sex;

    private DmsRole dmsRole;

}
