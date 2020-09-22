package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-09-14 11:10:55
 */
@Data
@TableName("tb_contents")
public class ContentsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * tag表id
	 */
	private Long tagid;
	/**
	 * 分类id
	 */
	private Long classifyid;
	/**
	 * 
	 */
	//private Blob contentsdata;
	/**
	 * 侧栏目数据
	 */
	private String sidedata;
	/**
	 * 头部图片
	 */
	private String imguri;
	/**
	 * 
	 */
	@JsonFormat(pattern="yyyy-MM-dd") //从数据库读出日期格式时，进行转换的规则
	@DateTimeFormat(pattern = "yyyy-MM-dd")//接受从前端传入的日期格式，映射到java类日期属性的规则
	private Date savetime;

}
