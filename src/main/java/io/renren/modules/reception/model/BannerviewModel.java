package io.renren.modules.reception.model;

import com.baomidou.mybatisplus.annotation.TableId;
import io.renren.modules.sys.entity.imgtype.Type;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BannerviewModel<T extends Type> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private Long id;
    /**
     *
     */
    private List<T> list;
    /**
     *
     */
    private String title;
    /**
     *
     */
    private String description;
}
