package org.wso2.carbon.apimgt.micro.gateway.api.synchronizer.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;


@ApiModel(description = "")
public class SubscriptionDTO  {
  
  
  
  private String subscriptionId = null;
  
  @NotNull
  private String applicationId = null;
  
  @NotNull
  private String apiIdentifier = null;
  
  @NotNull
  private String tier = null;
  
  public enum StatusEnum {
     BLOCKED,  PROD_ONLY_BLOCKED,  UNBLOCKED,  ON_HOLD,  REJECTED, 
  };
  
  private StatusEnum status = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("subscriptionId")
  public String getSubscriptionId() {
    return subscriptionId;
  }
  public void setSubscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("applicationId")
  public String getApplicationId() {
    return applicationId;
  }
  public void setApplicationId(String applicationId) {
    this.applicationId = applicationId;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("apiIdentifier")
  public String getApiIdentifier() {
    return apiIdentifier;
  }
  public void setApiIdentifier(String apiIdentifier) {
    this.apiIdentifier = apiIdentifier;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("tier")
  public String getTier() {
    return tier;
  }
  public void setTier(String tier) {
    this.tier = tier;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionDTO {\n");
    
    sb.append("  subscriptionId: ").append(subscriptionId).append("\n");
    sb.append("  applicationId: ").append(applicationId).append("\n");
    sb.append("  apiIdentifier: ").append(apiIdentifier).append("\n");
    sb.append("  tier: ").append(tier).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
