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
 * 陪玩人员
 *
 * @author 
 * @email
 */
@TableName("peiwanrenyuan")
public class PeiwanrenyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PeiwanrenyuanEntity() {

	}

	public PeiwanrenyuanEntity(T t) {
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
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 陪玩人员编号
     */
    @TableField(value = "peiwanrenyuan_uuid_mumber")

    private String peiwanrenyuanUuidMumber;


    /**
     * 陪玩人员姓名
     */
    @TableField(value = "peiwanrenyuan_name")

    private String peiwanrenyuanName;


    /**
     * 陪玩人员手机号
     */
    @TableField(value = "peiwanrenyuan_phone")

    private String peiwanrenyuanPhone;


    /**
     * 陪玩人员身份证号
     */
    @TableField(value = "peiwanrenyuan_id_number")

    private String peiwanrenyuanIdNumber;


    /**
     * 陪玩人员头像
     */
    @TableField(value = "peiwanrenyuan_photo")

    private String peiwanrenyuanPhoto;


    /**
     * 价格/小时
     */
    @TableField(value = "peiwanrenyuan_jiage")

    private Double peiwanrenyuanJiage;


    /**
     * 擅长游戏
     */
    @TableField(value = "peiwanrenyuan_shanchang")

    private String peiwanrenyuanShanchang;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 陪玩人员详细介绍
     */
    @TableField(value = "peiwanrenyuan_content")

    private String peiwanrenyuanContent;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：陪玩人员编号
	 */
    public String getPeiwanrenyuanUuidMumber() {
        return peiwanrenyuanUuidMumber;
    }
    /**
	 * 获取：陪玩人员编号
	 */

    public void setPeiwanrenyuanUuidMumber(String peiwanrenyuanUuidMumber) {
        this.peiwanrenyuanUuidMumber = peiwanrenyuanUuidMumber;
    }
    /**
	 * 设置：陪玩人员姓名
	 */
    public String getPeiwanrenyuanName() {
        return peiwanrenyuanName;
    }
    /**
	 * 获取：陪玩人员姓名
	 */

    public void setPeiwanrenyuanName(String peiwanrenyuanName) {
        this.peiwanrenyuanName = peiwanrenyuanName;
    }
    /**
	 * 设置：陪玩人员手机号
	 */
    public String getPeiwanrenyuanPhone() {
        return peiwanrenyuanPhone;
    }
    /**
	 * 获取：陪玩人员手机号
	 */

    public void setPeiwanrenyuanPhone(String peiwanrenyuanPhone) {
        this.peiwanrenyuanPhone = peiwanrenyuanPhone;
    }
    /**
	 * 设置：陪玩人员身份证号
	 */
    public String getPeiwanrenyuanIdNumber() {
        return peiwanrenyuanIdNumber;
    }
    /**
	 * 获取：陪玩人员身份证号
	 */

    public void setPeiwanrenyuanIdNumber(String peiwanrenyuanIdNumber) {
        this.peiwanrenyuanIdNumber = peiwanrenyuanIdNumber;
    }
    /**
	 * 设置：陪玩人员头像
	 */
    public String getPeiwanrenyuanPhoto() {
        return peiwanrenyuanPhoto;
    }
    /**
	 * 获取：陪玩人员头像
	 */

    public void setPeiwanrenyuanPhoto(String peiwanrenyuanPhoto) {
        this.peiwanrenyuanPhoto = peiwanrenyuanPhoto;
    }
    /**
	 * 设置：价格/小时
	 */
    public Double getPeiwanrenyuanJiage() {
        return peiwanrenyuanJiage;
    }
    /**
	 * 获取：价格/小时
	 */

    public void setPeiwanrenyuanJiage(Double peiwanrenyuanJiage) {
        this.peiwanrenyuanJiage = peiwanrenyuanJiage;
    }
    /**
	 * 设置：擅长游戏
	 */
    public String getPeiwanrenyuanShanchang() {
        return peiwanrenyuanShanchang;
    }
    /**
	 * 获取：擅长游戏
	 */

    public void setPeiwanrenyuanShanchang(String peiwanrenyuanShanchang) {
        this.peiwanrenyuanShanchang = peiwanrenyuanShanchang;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：陪玩人员详细介绍
	 */
    public String getPeiwanrenyuanContent() {
        return peiwanrenyuanContent;
    }
    /**
	 * 获取：陪玩人员详细介绍
	 */

    public void setPeiwanrenyuanContent(String peiwanrenyuanContent) {
        this.peiwanrenyuanContent = peiwanrenyuanContent;
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
        return "Peiwanrenyuan{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", peiwanrenyuanUuidMumber=" + peiwanrenyuanUuidMumber +
            ", peiwanrenyuanName=" + peiwanrenyuanName +
            ", peiwanrenyuanPhone=" + peiwanrenyuanPhone +
            ", peiwanrenyuanIdNumber=" + peiwanrenyuanIdNumber +
            ", peiwanrenyuanPhoto=" + peiwanrenyuanPhoto +
            ", peiwanrenyuanJiage=" + peiwanrenyuanJiage +
            ", peiwanrenyuanShanchang=" + peiwanrenyuanShanchang +
            ", sexTypes=" + sexTypes +
            ", peiwanrenyuanContent=" + peiwanrenyuanContent +
            ", createTime=" + createTime +
        "}";
    }
}
