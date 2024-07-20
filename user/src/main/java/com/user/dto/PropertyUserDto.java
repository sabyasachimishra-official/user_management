package com.user.dto;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.*;

public class PropertyUserDto {

    private Long id;

    @Size(min=10,max = 10,message = "should be exact 10 digits")
    private String mobile;

@NotNull
@Size(min = 2,message = "Should be at least 2 characters")
    private String name;
@Email
    private String emailId;

    private PageDetails pageDetails;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public PageDetails getPageDetails() {
        return pageDetails;
    }

    public void setPageDetails(PageDetails pageDetails) {
        this.pageDetails = pageDetails;
    }
}
