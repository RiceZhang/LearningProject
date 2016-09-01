package org.zrx.springframework.samples.mvc.form;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.zrx.springframework.samples.mvc.convert.MaskFormat;


import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * Function:    FormBean
 * Author:      zhangrixiong
 * DateTime:    2016/8/22 17:54
 */
public class FormBean {

    /*名称*/
    @NotEmpty
    private String name;

    /*年龄*/
    @Min(21)
    private int age;

    /*出生时间*/
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    @Past
    private Date birthDate;

    /*电话*/
    @MaskFormat("(###) ###-####")
    private String phone;

    /*货币*/
    @NumberFormat(pattern="$###,###.00")
    private BigDecimal currency;

    /*百分比*/
    @NumberFormat(style= NumberFormat.Style.PERCENT)
    private BigDecimal percent;

    /*参数查询*/
    private InquiryType inquiry;

    /*查询详细*/
    private String inquiryDetails;

    /*简述*/
    private boolean subscribeNewsletter;

    /*详细信息*/
    private Map<String, String> additionalInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getCurrency() {
        return currency;
    }

    public void setCurrency(BigDecimal currency) {
        this.currency = currency;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public InquiryType getInquiry() {
        return inquiry;
    }

    public void setInquiry(InquiryType inquiry) {
        this.inquiry = inquiry;
    }

    public String getInquiryDetails() {
        return inquiryDetails;
    }

    public void setInquiryDetails(String inquiryDetails) {
        this.inquiryDetails = inquiryDetails;
    }

    public boolean isSubscribeNewsletter() {
        return subscribeNewsletter;
    }

    public void setSubscribeNewsletter(boolean subscribeNewsletter) {
        this.subscribeNewsletter = subscribeNewsletter;
    }

    public Map<String, String> getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(Map<String, String> additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("properties name=");
        if (name != null) {
            sb.append("'").append(name).append("', ");
        } else {
            sb.append(name).append(", ");
        }
        sb.append("age=").append(age).append(", ");
        sb.append("birthDate=").append(birthDate).append(", ");
        sb.append("phone=");
        if (phone != null) {
            sb.append("'").append(phone).append("', ");
        } else {
            sb.append(phone).append(", ");
        }
        sb.append("currency=").append(currency).append(", ");
        sb.append("percent=").append(percent).append(", ");
        sb.append("inquiry=").append(inquiry).append(", ");
        sb.append("inquiryDetails=");
        if (inquiryDetails != null) {
            sb.append("'").append(inquiryDetails).append("', ");
        } else {
            sb.append(inquiryDetails).append(", ");
        }
        sb.append("subscribeNewsletter=").append(subscribeNewsletter).append(", ");
        sb.append("additionalInfo=").append(additionalInfo);
        return sb.toString();
    }

}
