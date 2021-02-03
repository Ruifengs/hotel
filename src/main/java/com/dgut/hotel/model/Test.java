package com.dgut.hotel.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ruifeng
 * @since 2021-02-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("test")
@ApiModel(value="Test对象", description="")
public class Test implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;

    private String username;


}
