package com.entity.view;

import com.entity.PeiwanrenyuanOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 陪玩人员订单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("peiwanrenyuan_order")
public class PeiwanrenyuanOrderView extends PeiwanrenyuanOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 陪玩游戏的值
		*/
		private String youxiValue;
		/**
		* 订单类型的值
		*/
		private String peiwanrenyuanOrderValue;
		/**
		* 支付类型的值
		*/
		private String peiwanrenyuanOrderPaymentValue;



		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 余额
			*/
			private Double newMoney;

		//级联表 peiwanrenyuan
			/**
			* 陪玩人员编号
			*/
			private String peiwanrenyuanUuidMumber;
			/**
			* 陪玩人员姓名
			*/
			private String peiwanrenyuanName;
			/**
			* 陪玩人员手机号
			*/
			private String peiwanrenyuanPhone;
			/**
			* 陪玩人员身份证号
			*/
			private String peiwanrenyuanIdNumber;
			/**
			* 陪玩人员头像
			*/
			private String peiwanrenyuanPhoto;
			/**
			* 价格/小时
			*/
			private Double peiwanrenyuanJiage;
			/**
			* 擅长游戏
			*/
			private String peiwanrenyuanShanchang;
			/**
			* 陪玩人员详细介绍
			*/
			private String peiwanrenyuanContent;

	public PeiwanrenyuanOrderView() {

	}

	public PeiwanrenyuanOrderView(PeiwanrenyuanOrderEntity peiwanrenyuanOrderEntity) {
		try {
			BeanUtils.copyProperties(this, peiwanrenyuanOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 陪玩游戏的值
			*/
			public String getYouxiValue() {
				return youxiValue;
			}
			/**
			* 设置： 陪玩游戏的值
			*/
			public void setYouxiValue(String youxiValue) {
				this.youxiValue = youxiValue;
			}
			/**
			* 获取： 订单类型的值
			*/
			public String getPeiwanrenyuanOrderValue() {
				return peiwanrenyuanOrderValue;
			}
			/**
			* 设置： 订单类型的值
			*/
			public void setPeiwanrenyuanOrderValue(String peiwanrenyuanOrderValue) {
				this.peiwanrenyuanOrderValue = peiwanrenyuanOrderValue;
			}
			/**
			* 获取： 支付类型的值
			*/
			public String getPeiwanrenyuanOrderPaymentValue() {
				return peiwanrenyuanOrderPaymentValue;
			}
			/**
			* 设置： 支付类型的值
			*/
			public void setPeiwanrenyuanOrderPaymentValue(String peiwanrenyuanOrderPaymentValue) {
				this.peiwanrenyuanOrderPaymentValue = peiwanrenyuanOrderPaymentValue;
			}























				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}


				//级联表的get和set peiwanrenyuan

					/**
					* 获取： 陪玩人员编号
					*/
					public String getPeiwanrenyuanUuidMumber() {
						return peiwanrenyuanUuidMumber;
					}
					/**
					* 设置： 陪玩人员编号
					*/
					public void setPeiwanrenyuanUuidMumber(String peiwanrenyuanUuidMumber) {
						this.peiwanrenyuanUuidMumber = peiwanrenyuanUuidMumber;
					}

					/**
					* 获取： 陪玩人员姓名
					*/
					public String getPeiwanrenyuanName() {
						return peiwanrenyuanName;
					}
					/**
					* 设置： 陪玩人员姓名
					*/
					public void setPeiwanrenyuanName(String peiwanrenyuanName) {
						this.peiwanrenyuanName = peiwanrenyuanName;
					}

					/**
					* 获取： 陪玩人员手机号
					*/
					public String getPeiwanrenyuanPhone() {
						return peiwanrenyuanPhone;
					}
					/**
					* 设置： 陪玩人员手机号
					*/
					public void setPeiwanrenyuanPhone(String peiwanrenyuanPhone) {
						this.peiwanrenyuanPhone = peiwanrenyuanPhone;
					}

					/**
					* 获取： 陪玩人员身份证号
					*/
					public String getPeiwanrenyuanIdNumber() {
						return peiwanrenyuanIdNumber;
					}
					/**
					* 设置： 陪玩人员身份证号
					*/
					public void setPeiwanrenyuanIdNumber(String peiwanrenyuanIdNumber) {
						this.peiwanrenyuanIdNumber = peiwanrenyuanIdNumber;
					}

					/**
					* 获取： 陪玩人员头像
					*/
					public String getPeiwanrenyuanPhoto() {
						return peiwanrenyuanPhoto;
					}
					/**
					* 设置： 陪玩人员头像
					*/
					public void setPeiwanrenyuanPhoto(String peiwanrenyuanPhoto) {
						this.peiwanrenyuanPhoto = peiwanrenyuanPhoto;
					}

					/**
					* 获取： 价格/小时
					*/
					public Double getPeiwanrenyuanJiage() {
						return peiwanrenyuanJiage;
					}
					/**
					* 设置： 价格/小时
					*/
					public void setPeiwanrenyuanJiage(Double peiwanrenyuanJiage) {
						this.peiwanrenyuanJiage = peiwanrenyuanJiage;
					}

					/**
					* 获取： 擅长游戏
					*/
					public String getPeiwanrenyuanShanchang() {
						return peiwanrenyuanShanchang;
					}
					/**
					* 设置： 擅长游戏
					*/
					public void setPeiwanrenyuanShanchang(String peiwanrenyuanShanchang) {
						this.peiwanrenyuanShanchang = peiwanrenyuanShanchang;
					}

					/**
					* 获取： 陪玩人员详细介绍
					*/
					public String getPeiwanrenyuanContent() {
						return peiwanrenyuanContent;
					}
					/**
					* 设置： 陪玩人员详细介绍
					*/
					public void setPeiwanrenyuanContent(String peiwanrenyuanContent) {
						this.peiwanrenyuanContent = peiwanrenyuanContent;
					}




}
