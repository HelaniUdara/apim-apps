package org.wso2.carbon.apimgt.rest.api.admin.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;

import javax.xml.bind.annotation.*;
import org.wso2.carbon.apimgt.rest.api.util.annotations.Scope;



public class TokenValidationDTO   {
  
    private Boolean enable = true;

@XmlType(name="TypeEnum")
@XmlEnum(String.class)
public enum TypeEnum {

    @XmlEnumValue("REGEX") REGEX(String.valueOf("REGEX")), @XmlEnumValue("JWT") JWT(String.valueOf("JWT")), @XmlEnumValue("CUSTOM") CUSTOM(String.valueOf("CUSTOM"));


    private String value;

    TypeEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static TypeEnum fromValue(String v) {
        for (TypeEnum b : TypeEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}

    private TypeEnum type = null;
    private Object value = null;

  /**
   **/
  public TokenValidationDTO enable(Boolean enable) {
    this.enable = enable;
    return this;
  }

  
  @ApiModelProperty(example = "false", value = "")
  @JsonProperty("enable")
  public Boolean isEnable() {
    return enable;
  }
  public void setEnable(Boolean enable) {
    this.enable = enable;
  }

  /**
   **/
  public TokenValidationDTO type(TypeEnum type) {
    this.type = type;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }
  public void setType(TypeEnum type) {
    this.type = type;
  }

  /**
   **/
  public TokenValidationDTO value(Object value) {
    this.value = value;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("value")
  public Object getValue() {
    return value;
  }
  public void setValue(Object value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenValidationDTO tokenValidation = (TokenValidationDTO) o;
    return Objects.equals(enable, tokenValidation.enable) &&
        Objects.equals(type, tokenValidation.type) &&
        Objects.equals(value, tokenValidation.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enable, type, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenValidationDTO {\n");
    
    sb.append("    enable: ").append(toIndentedString(enable)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

