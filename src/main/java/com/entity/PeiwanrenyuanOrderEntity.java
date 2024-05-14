package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 陪玩人员订单
 *
 * @author 
 * @email
 */
@TableName("peiwanrenyuan_order")
public class PeiwanrenyuanOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PeiwanrenyuanOrderEntity() {

	}

	public PeiwanrenyuanOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 订单号
     */
    @TableField(value = "peiwanrenyuan_order_uuid_number")

    private String peiwanrenyuanOrderUuidNumber;


    /**
     * 陪玩人员
     */
    @TableField(value = "peiwanrenyuan_id")

    private Integer peiwanrenyuanId;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 陪玩游戏
     */
    @TableField(value = "youxi_types")

    private Integer youxiTypes;


    /**
     * 开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "kaishi_time")

    private Date kaishiTime;


    /**
     * 购买小时
     */
    @TableField(value = "buy_number")

    private Integer buyNumber;


    /**
     * 实付价格
     */
    @TableField(value = "peiwanrenyuan_order_true_price")

    private Double peiwanrenyuanOrderTruePrice;


    /**
     * 订单类型
     */
    @TableField(value = "peiwanrenyuan_order_types")

    private Integer peiwanrenyuanOrderTypes;


    /**
     * 支付类型
     */
    @TableField(value = "peiwanrenyuan_order_payment_types")

    private Integer peiwanrenyuanOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public String getPeiwanrenyuanOrderUuidNumber() {
        return peiwanrenyuanOrderUuidNumber;
    }
    /**
	 * 获取：订单号
	 */

    public void setPeiwanrenyuanOrderUuidNumber(String peiwanrenyuanOrderUuidNumber) {
        this.peiwanrenyuanOrderUuidNumber = peiwanrenyuanOrderUuidNumber;
    }
    /**
	 * 设置：陪玩人员
	 */
    public Integer getPeiwanrenyuanId() {
        return peiwanrenyuanId;
    }
    /**
	 * 获取：陪玩人员
	 */

    public void setPeiwanrenyuanId(Integer peiwanrenyuanId) {
        this.peiwanrenyuanId = peiwanrenyuanId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：陪玩游戏
	 */
    public Integer getYouxiTypes() {
        return youxiTypes;
    }
    /**
	 * 获取：陪玩游戏
	 */

    public void setYouxiTypes(Integer youxiTypes) {
        this.youxiTypes = youxiTypes;
    }
    /**
	 * 设置：开始时间
	 */
    public Date getKaishiTime() {
        return kaishiTime;
    }
    /**
	 * 获取：开始时间
	 */

    public void setKaishiTime(Date kaishiTime) {
        this.kaishiTime = kaishiTime;
    }
    /**
	 * 设置：购买小时
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }
    /**
	 * 获取：购买小时
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getPeiwanrenyuanOrderTruePrice() {
        return peiwanrenyuanOrderTruePrice;
    }
    /**
	 * 获取：实付价格
	 */

    public void setPeiwanrenyuanOrderTruePrice(Double peiwanrenyuanOrderTruePrice) {
        this.peiwanrenyuanOrderTruePrice = peiwanrenyuanOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getPeiwanrenyuanOrderTypes() {
        return peiwanrenyuanOrderTypes;
    }
    /**
	 * 获取：订单类型
	 */

    public void setPeiwanrenyuanOrderTypes(Integer peiwanrenyuanOrderTypes) {
        this.peiwanrenyuanOrderTypes = peiwanrenyuanOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getPeiwanrenyuanOrderPaymentTypes() {
        return peiwanrenyuanOrderPaymentTypes;
    }
    /**
	 * 获取：支付类型
	 */

    public void setPeiwanrenyuanOrderPaymentTypes(Integer peiwanrenyuanOrderPaymentTypes) {
        this.peiwanrenyuanOrderPaymentTypes = peiwanrenyuanOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PeiwanrenyuanOrder{" +
            "id=" + id +
            ", peiwanrenyuanOrderUuidNumber=" + peiwanrenyuanOrderUuidNumber +
            ", peiwanrenyuanId=" + peiwanrenyuanId +
            ", yonghuId=" + yonghuId +
            ", youxiTypes=" + youxiTypes +
            ", kaishiTime=" + kaishiTime +
            ", buyNumber=" + buyNumber +
            ", peiwanrenyuanOrderTruePrice=" + peiwanrenyuanOrderTruePrice +
            ", peiwanrenyuanOrderTypes=" + peiwanrenyuanOrderTypes +
            ", peiwanrenyuanOrderPaymentTypes=" + peiwanrenyuanOrderPaymentTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
