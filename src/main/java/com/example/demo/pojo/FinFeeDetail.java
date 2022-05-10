package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
     * get应缴金额
     */
    public BigDecimal getAmountNotNull() {
        return this.amount == null ? BigDecimal.ZERO : this.amount;
    }

    /**
     * get应付金额
     */
    public BigDecimal getPayableAmountNotNull() {
        return this.payableAmount == null ? BigDecimal.ZERO : this.getPayableAmount();
    }

    /**
     * order_fin_fee 的冗余orderNo（不冗余subOrderNo)
     */
    private String finOrderNo;
}

