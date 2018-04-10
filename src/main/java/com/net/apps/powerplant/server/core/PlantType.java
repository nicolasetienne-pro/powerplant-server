package com.net.apps.powerplant.server.core;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Plant Type
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PlantType {
  @ApiModelProperty("id")
  private Integer id = null;

  @ApiModelProperty("name")
  private String name = null;

}

