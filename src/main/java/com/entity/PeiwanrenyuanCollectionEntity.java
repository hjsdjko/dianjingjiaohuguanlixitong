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
 * 陪玩人员收藏
 *
 * @author 
 * @email
 */
@TableName("peiwanrenyuan_collection")
public class PeiwanrenyuanCollectionEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PeiwanrenyuanCollectionEntity() {

	}

	public PeiwanrenyuanCollectionEntity(T t) {
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
     * 类型
     */
    @TableField(value = "peiwanrenyuan_collection_types")

    private Integer peiwanrenyuanCollectionTypes;


    /**
     * 收藏时间
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
	 * 设置：类型
	 */
    public Integer getPeiwanrenyuanCollectionTypes() {
        return peiwanrenyuanCollectionTypes;
    }
    /**
	 * 获取：类型
	 */

    public void setPeiwanrenyuanCollectionTypes(Integer peiwanrenyuanCollectionTypes) {
        this.peiwanrenyuanCollectionTypes = peiwanrenyuanCollectionTypes;
    }
    /**
	 * 设置：收藏时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：收藏时间
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
        return "PeiwanrenyuanCollection{" +
            "id=" + id +
            ", peiwanrenyuanId=" + peiwanrenyuanId +
            ", yonghuId=" + yonghuId +
            ", peiwanrenyuanCollectionTypes=" + peiwanrenyuanCollectionTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
