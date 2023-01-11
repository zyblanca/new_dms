package com.example.dms.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * 角色信息表(DmsRole)实体类
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */

@Data
public class DmsRole implements Serializable {
    private static final long serialVersionUID = 804051825960942884L;
    /**
    * 角色ID（主键、自增）
    */
    private Integer roleId;
    /**
    * 角色编号
    */
    private String roleCode;
    /**
    * 角色名称
    */
    private String roleName;

    private List<DmsUser> dmsUsers;
}
