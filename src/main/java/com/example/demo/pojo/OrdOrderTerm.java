package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hailiang.orm.mybatis.plugin.api.annotation.Created;
import com.hailiang.orm.mybatis.plugin.api.annotation.Updated;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 学期订单信息表(OrdOrderTerm)实体类
 *
 * @author makejava
 * @since 2021-05-26 15:29:06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ord_order_term")
public class OrdOrderTerm implements Serializable {
    private static final long serialVersionUID = -15902135031665370L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学期订单编号
     */
    private String termOrderNo;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 订单类型 1-报名 2-择升 3-升级
     */
    private String orderType;

    /**
     * 学生学号
     */
    private String sno;

    /**
     * 学生姓名
     */
    private String fullName;

    /**
     * 1- 上学期,2- 下学期
     */
    private String payOwnerType;

    /**
     * 报名学年
     */
    private String signYearType;

    /**
     * 报名学期
     */
    private String signTermType;

    /**
     * 收费标准总额
     */
    private BigDecimal standardAmount;

    /**
     * 应收金额
     */
    private BigDecimal totalAmount;

    /**
     * 实收金额
     */
    private BigDecimal actualAmount;

    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;

    /**
     * 实时收费标准总额
     */
    private BigDecimal timelinessStandardAmount;

    /**
     * 实时优惠金额
     */
    private BigDecimal timelinessDiscountAmount;

    /**
     * 实时应收金额
     */
    private BigDecimal timelinessAmount;

    /**
     * 实时实收金额
     */
    private BigDecimal timelinessActualAmount;

    /**
     * 退款金额
     */
    private BigDecimal refundAmount;

    /**
     * 支付渠道编号
     */
    private String payChannelNo;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 支付流水号
     */
    private String paymentNo;

    /**
     * 订单支付状态1- 待支付,2- 支付待确认 ,3- 已支付
     */
    private String orderPayStatus;

    /**
     * 是否需要退费 0否1是
     */
    private String needRefundStatus;

    /**
     * 是否删除 ，0：不删除，1： 删除
     */
    private Boolean isDeleted;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 应付金额
     */
    private BigDecimal payableAmount;

    /**
     * 创建时间（YYYY-MM-DD hh:mm:ss）
     */
    @Created
    private Date createTime;

    /**
     * 更新时间
     */
    @Updated
    private Date updateTime;

    /**
     * 更新人
     */
    private String editor;

    /**
     * 实时应付金额
     */
    private BigDecimal timelinessPayableAmount;

    /**
     * 订单推送状态
     */
    private String orderSendStatus;


}