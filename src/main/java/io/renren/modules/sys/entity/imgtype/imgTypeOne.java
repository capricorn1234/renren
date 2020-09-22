package io.renren.modules.sys.entity.imgtype;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class imgTypeOne extends Type{
    @NotBlank(message = "URL不能为空")
    private String imgURL;
    private String imgtitle;
    private String description;
}
