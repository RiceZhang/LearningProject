package org.zrx.springframework.samples.mvc.form;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.zrx.springframework.samples.mvc.convert.MaskFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * Function:    FormBean ---- 表单值类
 * Author:      zhangrixiong
 * DateTime:    2016/8/22 17:54
 */
public class FormBean {

    @NotEmpty
    private String name; // 姓名

    @Min(21)
    private int age; // 年龄

    @DateTimeFormat(iso=ISO.DATE)
    @Past
    private Date birthDay; // 出身日期

    @MaskFormat("(###) ###-###")
    private String phone; // 电话

    @NumberFormat(pattern = "$###,###.00")
    private BigDecimal currency; // 货币

    @NumberFormat(style = Style.PERCENT)
    private BigDecimal percent; // 百分比

    private InquiryType inquiry; // 查询类型

    private String inquuiryDatails; // 询价详细

    private boolean subscribeNewsletter; // 订阅简报

    private Map<String, String> additionalInfo; // 地址信息

    public FormBean() {
    }
}
