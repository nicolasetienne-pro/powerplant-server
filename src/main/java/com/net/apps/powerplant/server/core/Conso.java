package com.net.apps.powerplant.server.core;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Conso
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Conso {
  @ApiModelProperty("id")
  private Long id = null;

  @ApiModelProperty("plantId")
  private Long plantId = null;

  @ApiModelProperty("userId")
  private Long userId = null;

  @ApiModelProperty("quantity")
  private Double quantity = null;

  @ApiModelProperty("consoDate")
  private LocalDateTime consoDate = null;

  public Conso id(Long id) {
    this.id = id;
    return this;
  }
}

