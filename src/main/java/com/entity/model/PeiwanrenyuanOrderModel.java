package com.entity.model;

import com.entity.PeiwanrenyuanOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 陪玩人员订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PeiwanrenyuanOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String peiwanrenyuanOrderUuidNumber;


    /**
     * 陪玩人员
     */
    private Integer peiwanrenyuanId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 陪玩游戏
     */
    private Integer youxiTypes;


    /**
     * 开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date kaishiTime;


    /**
     * 购买小时
     */
    private Integer buyNumber;


    /**
     * 实付价格
     */
    private Double peiwanrenyuanOrderTruePrice;


    /**
     * 订单类型
     */
    private Integer peiwanrenyuanOrderTypes;


    /**
     * 支付类型
     */
    private Integer peiwanrenyuanOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单号
	 */
    public String getPeiwanrenyuanOrderUuidNumber() {
        return peiwanrenyuanOrderUuidNumber;
    }


    /**
	 * 设置：订单号
	 */
    public void setPeiwanrenyuanOrderUuidNumber(String peiwanrenyuanOrderUuidNumber) {
        this.peiwanrenyuanOrderUuidNumber = peiwanrenyuanOrderUuidNumber;
    }
    /**
	 * 获取：陪玩人员
	 */
    public Integer getPeiwanrenyuanId() {
        return peiwanrenyuanId;
    }


    /**
	 * 设置：陪玩人员
	 */
    public void setPeiwanrenyuanId(Integer peiwanrenyuanId) {
        this.peiwanrenyuanId = peiwanrenyuanId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：陪玩游戏
	 */
    public Integer getYouxiTypes() {
        return youxiTypes;
    }


    /**
	 * 设置：陪玩游戏
	 */
    public void setYouxiTypes(Integer youxiTypes) {
        this.youxiTypes = youxiTypes;
    }
    /**
	 * 获取：开始时间
	 */
    public Date getKaishiTime() {
        return kaishiTime;
    }


    /**
	 * 设置：开始时间
	 */
    public void setKaishiTime(Date kaishiTime) {
        this.kaishiTime = kaishiTime;
    }
    /**
	 * 获取：购买小时
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 设置：购买小时
	 */
    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getPeiwanrenyuanOrderTruePrice() {
        return peiwanrenyuanOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setPeiwanrenyuanOrderTruePrice(Double peiwanrenyuanOrderTruePrice) {
        this.peiwanrenyuanOrderTruePrice = peiwanrenyuanOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getPeiwanrenyuanOrderTypes() {
        return peiwanrenyuanOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setPeiwanrenyuanOrderTypes(Integer peiwanrenyuanOrderTypes) {
        this.peiwanrenyuanOrderTypes = peiwanrenyuanOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getPeiwanrenyuanOrderPaymentTypes() {
        return peiwanrenyuanOrderPaymentTypes;
    }


    /**
	 * 设置：支付类型
	 */
    public void setPeiwanrenyuanOrderPaymentTypes(Integer peiwanrenyuanOrderPaymentTypes) {
        this.peiwanrenyuanOrderPaymentTypes = peiwanrenyuanOrderPaymentTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
