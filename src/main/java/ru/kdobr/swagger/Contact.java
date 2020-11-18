package ru.kdobr.swagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Our contact model")
public class Contact {

    @ApiModelProperty(notes = "Unique id of the contact")
    private String Id;
    @ApiModelProperty(notes = "name of the contact")
    private String name;
    private String phone;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
