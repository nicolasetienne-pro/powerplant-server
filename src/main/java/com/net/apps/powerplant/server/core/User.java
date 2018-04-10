package com.net.apps.powerplant.server.core;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * User
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User   {
  @ApiModelProperty(value = "Id")
  private Long id = null;

  @ApiModelProperty(value = "User login")
  private String username = null;

  @ApiModelProperty(value = "Uer first name")
  private String firstName = null;

  @ApiModelProperty(value = "User last name")
  private String lastName = null;

  @ApiModelProperty(value = "User password ???")
  private String password = null;

  @ApiModelProperty(value = "User Status")
  private Integer userStatus = null;

  public User id(Long id) {
    this.id = id;
    return this;
  }

  public User username(String username) {
    this.username = username;
    return this;
  }
}

