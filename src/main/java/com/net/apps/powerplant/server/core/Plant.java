package com.net.apps.powerplant.server.core;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Plant
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Plant   {
  @ApiModelProperty("id")
  private Integer id = null;

  @ApiModelProperty(required = true, value = "type")
  private PlantType type = null;

  @ApiModelProperty(required = true, value = "name")
  private String name;

  @ApiModelProperty(required = true, value = "capacity")
  private Long capacity;

  @ApiModelProperty("Consumption history")
  private List<Conso> consumptions = null;

}

