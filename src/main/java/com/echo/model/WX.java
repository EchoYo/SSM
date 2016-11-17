package com.echo.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Echoj on 2016/4/25.
 */
public class WX {
    private Integer id;
    private Date start_date;
    private String exp_date;
    private String start_date_code;
    private Integer month;
    private String qyt;
    private String order_id;
    private String item_no;
    private String build_no;
    private String coocn;
    private String type_id;
    private String start_date_str;

    public WX(){
    }

    public WX(String order_id,String type_id,String build_no,Integer month,String item_no,String qyt){
        this.order_id = order_id;
        this.type_id = type_id;
        this.build_no = build_no;
        this.month = month;
        this.item_no = item_no;
        this.qyt = qyt;
        //获取出库日期编码
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        this.start_date_str = sdf.format(now);
        this.start_date_code = start_date_str + "-00001";
        //计算保质期(不是按自然月)
        Calendar calendar = Calendar.getInstance();
        int date = calendar.get(Calendar.DATE);
        calendar.add(Calendar.MONTH,month);
        int date_new = calendar.get(Calendar.DATE);
        calendar.add(Calendar.DATE,(date - date_new));
        now = calendar.getTime();
        this.exp_date = sdf.format(now);
        //计算二维码
        this.coocn = "(A)" +order_id + "$$" + "(B)" + item_no + "$$" + "(C)" + build_no +
                "$$" + "(D)" + qyt + "$$" + "(E)" + "JT Group" + "$$" + "(F)" + type_id + "$$" + "(G)"
                + start_date_code + "$$" + "(H)" + start_date_str + "$$" + "(I)" + "100282" +
                "$$" + "(J)" + exp_date + "$$";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }

    public String getStart_date_code() {
        return start_date_code;
    }

    public void setStart_date_code(String start_date_code) {
        this.start_date_code = start_date_code;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getQyt() {
        return qyt;
    }

    public void setQyt(String qyt) {
        this.qyt = qyt;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getItem_no() {
        return item_no;
    }

    public void setItem_no(String item_no) {
        this.item_no = item_no;
    }

    public String getBuild_no() {
        return build_no;
    }

    public void setBuild_no(String build_no) {
        this.build_no = build_no;
    }

    public String getCoocn() {
        return coocn;
    }

    public void setCoocn(String coocn) {
        this.coocn = coocn;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getStart_date_str() {
        return start_date_str;
    }

    public void setStart_date_str(String start_date_str) {
        this.start_date_str = start_date_str;
    }

    @Override
    public String toString() {
        return "WX{" +
                "id=" + id +
                ", start_date=" + start_date +
                ", exp_date='" + exp_date + '\'' +
                ", start_date_code='" + start_date_code + '\'' +
                ", month=" + month +
                ", qyt='" + qyt + '\'' +
                ", order_id='" + order_id + '\'' +
                ", item_no='" + item_no + '\'' +
                ", build_no='" + build_no + '\'' +
                ", coocn='" + coocn + '\'' +
                ", type_id='" + type_id + '\'' +
                ", start_date_str='" + start_date_str + '\'' +
                '}';
    }
}
