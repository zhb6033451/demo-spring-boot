package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import java.math.BigDecimal;

/**
 * 费用明细表
 * fin_fee_detail(FinFeeDetail)实体类
 *
 * @author makejava
 * @since 2020-12-29 14:33:11
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
@TableName("fin_fee_detail")
public class FinFeeDetail extends BaseDO {
    private static final long serialVersionUID = -54405953730920037L;
    /**
     * 自增ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 费用编号
     */
    private String feeNo;

    /**
     * 收费项目名称
     */
    private String itemName;

    /**
     * 收费项目ID
     */
    private Integer itemId;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 减免金额
     */
    private BigDecimal discountAmount;

    /**
     * 减免原因
     */
    private String discountReason;

    /**
     * 学号
     */
    private String sno;

    /**
     * 缴费学号
     */
    private String paymentSno;

    /**
     * 学年
     */
    private String signYearType;

    /**
     * 学期
     */
    private String signTermType;

    /**
     * 费用类型(1-报名,2-分班,3-升级,4-择生.5-在册)
     */
    private Integer feeType;

    /**
     * 招生类型(0-秋招.1-春招.2-插班生)
     */
    private Integer enrollType;

    /**
     * 父收费项名称
     */
    private String itemTypeName;

    /**
     * 收费标准金额
     */
    private BigDecimal standardAmount;

    /**
     * 减免原因数组
     */
    // private List<FinFeeDetailDiscountModel> discountReasonList;

    /**
     * 项目类型(1 接送费 2 寝室费  没填： 默认)
     */
    private Integer itemType;

    /**
     * 入账单位
     */
    private String accountUnit;

    /**
     * 项目属性
     */
    private String itemProperties;

    /**
     * 属性规则
     */
    private String propertyRules;

    /**
     * 项目编码（项目唯一标志）
     */
    private String itemCode;

    /**
     * 实时应缴金额
     */
    private BigDecimal timelinessAmount;

    /**
     * 实时实缴金额
     */
    private BigDecimal timelinessActurlAmount;

    /**
     * 是否定费调整流程(0否 1是)
     */
    private Boolean isFlow;

    /**
     * 是否调整(0否 1是)
     */
    @Column(columnDefinition = "Boolean defalut '0'")
    private Boolean isAdjust;

    /**
     * 分账金额
     */
    private BigDecimal splitAmount;

    /**
     * 应付金额
     */
    private BigDecimal payableAmount;

    /**
     * 实时应付金额
     */
    private BigDecimal timelinessPayableAmount;

    /**
     * 关联ID
     */
    private String relateId;

    /**
     * 实时标准金额
     */
    private BigDecimal timelinessStandardAmount;

    /**
     * order_fin_fee 的冗余orderNo（不冗余subOrderNo)
     */
    private String finOrderNo;

    @ApiModelProperty(value = "应退金额")
    private BigDecimal refundAmount;

    @ApiModelProperty(value = "财务核定退费金额")
    private BigDecimal financeRefundAmount;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "原实时应缴")
    private BigDecimal oldTimelinessAmount;

    @ApiModelProperty(value = "实收-应退金额")
    private BigDecimal ActurlRefundAmount;

    @ApiModelProperty(value = "实退金额")
    private BigDecimal timelinessRefundAmount;

    @ApiModelProperty(value = "系统实际退费/补费类型")
    private String rasAmountType;

    @ApiModelProperty(value = "系统实际退费/补费总额")
    private BigDecimal rasAmount;
}

