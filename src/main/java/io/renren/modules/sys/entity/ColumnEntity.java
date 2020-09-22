package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-09-14 11:10:55
 */
@Data
@TableName("tb_column")
public class ColumnEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 栏目标题
	 */
	private String columntitle;
	/**
	 * 0 文本 1列表 2图文列表 3 图片 4 tag或分类列表
	 */
	private Integer columntype;
	/**
	 * json 数据
	 */
	private String columndata;
	/**
	 * 状态 0 无效  1有效
	 */
	private String columnstatus;
	/**
	 * 排序字段
	 */
	private Integer columnsort;
	/**
	 * 
	 */
	@JsonFormat(pattern="yyyy-MM-dd") //从数据库读出日期格式时，进行转换的规则
	@DateTimeFormat(pattern = "yyyy-MM-dd")//接受从前端传入的日期格式，映射到java类日期属性的规则
	private Date savetime;

}
