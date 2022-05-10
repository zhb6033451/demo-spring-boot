package com.example.demo.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseDO implements Serializable {
    private static final long serialVersionUID = -6760540486650387670L;
    /**
     * 是否已删除：0 不删除，1 删除
     */
    private Boolean isDeleted;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人
     */
    private String editor;
    /**
     * 修改时间
     */
    private Date updateTime;

    public BaseDO() {
    }
}
