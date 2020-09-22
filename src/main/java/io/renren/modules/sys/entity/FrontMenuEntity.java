package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-09-14 11:10:55
 */
@Data
@TableName("tb_front_menu")
public class FrontMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	@NotBlank(message = "菜单名字不能为空")
	private String menuname;
	/**
	 * 
	 */
	private String menuuri;
	/**
	 * 
	 */
	private Long parentid;
	@TableField(exist = false)
	private String parentName;
	/**
	 * 点击后访问的类型 1 文本 2列表
	 */
	private Integer menutype;
	/**
	 * json 参数
	 */
	private String menueparam;
	@TableField(exist=false)
	private Boolean open;

	@TableField(exist=false)
	private List<?> list;

}
