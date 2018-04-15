package com.net.apps.powerplant.server.core;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Releve
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Releve {
  @ApiModelProperty("id")
  private Integer id = null;

  @ApiModelProperty("plantId")
  private Integer plantId = null;

  @ApiModelProperty("userId")
  private Integer userId = null;

  @ApiModelProperty("indexCompteur")
  private Long indexCompteur = null;

  @ApiModelProperty("timestamp")
  private LocalDateTime timestamp = null;

}

