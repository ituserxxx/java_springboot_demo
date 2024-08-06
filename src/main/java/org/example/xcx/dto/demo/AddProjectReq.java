package org.example.xcx.dto.demo;

import lombok.Data;
import org.example.xcx.validtion.NotSpace;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class AddProjectReq {
    //
    private String Name;
    private String WallpaperId;
    //<15 notnull 中间不能有空格
    @NotNull(message = "网关名称不能为空")
    @Length(max = 14,message = "网关名称不能超过15个字符")
    @NotSpace(message = "网关名称不能包含空格")
    private String GatewayName;
    private String GatewayModel;
    private String[] GatewayId;

    private AddProjectRes user;

}
