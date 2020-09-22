package io.renren.modules.sys.form;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class ColumnFrom{
    /**
     *数据id
     */
    private Long id;
    /**
     * 0 文本 1列表 2图文列表 3 图片 4 tag或分类列表
     */
    @Range(min=0, max=2, message = "类型错误")
    private Integer columntype;
    @NotBlank(message = "标题不能为空")
    private String columntitle;
    /**
     * 对象数据前台传递
     */
    private String columndata;
    /**
     * 状态 0 无效  1有效
     */
    @NotBlank(message = "状态码不能为空")
    private String columnstatus;
    /**
     * 排序字段
     */
    @NotNull(message = "排序字段不能为空")
    private Integer columnsort;
}
