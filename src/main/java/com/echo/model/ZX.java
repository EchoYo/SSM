package com.echo.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>Description:紫翔标签</p>
 * Created by Echoj on 2016/4/18.
 */
public class ZX {
    private Integer serial_no;
    private Date start_date;
    private String exp_date;
    private String mat_lot;
    private String qty;
    private String barcode;
    private Integer month;
    private String qty_str;
    private String type_id;
    private String mat_code;
    private String batch;

    public ZX(){

    }

    public ZX(String type_id,Integer month,String qty,String mat_code,String batch,String st_date){
        this.type_id = type_id;
        this.month = month;
        this.qty = qty;
        this.mat_code = mat_code;
        this.batch = batch;
        SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        SimpleDateFormat sdfm = new SimpleDateFormat("MM");
        SimpleDateFormat sdfn = new SimpleDateFormat("dd");
        Date now = null;
        try {
            now = sdfs.parse(st_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String m = sdfm.format(now);
        String n = sdfn.format(now);
        int mo = Integer.parseInt(m);
        if(mo > 9){
            char s = (char) ('A'+(mo-10));
            m = String.valueOf(s);
        }else{
            m = String.valueOf(mo);
        }
        String stDate = m + n;
        //根据输入的保质期（月）计算出保质期
        Calendar calendar = Calendar.getInstance();
        assert now != null;
        calendar.setTime(now);
        int date = calendar.get(Calendar.DATE);
        calendar.add(Calendar.MONTH, month);
        int date_new = calendar.get(Calendar.DATE);
        calendar.add(Calendar.DATE,(date - date_new));
        now = calendar.getTime();
        this.exp_date = sdf.format(now);
        //根据编码计算出mat_lot
        this.mat_lot = type_id + batch + stDate;
        //计算出barcode
        this.qty_str = qty;
        while (qty_str.length() < 7) {
            qty_str = "0" + qty_str;
        }
        this.barcode = exp_date + qty_str + "00" + mat_lot;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getMat_code() {
        return mat_code;
    }

    public void setMat_code(String mat_code) {
        this.mat_code = mat_code;
    }

    public Integer getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(Integer serial_no) {
        this.serial_no = serial_no;
    }

    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getMat_lot() {
        return mat_lot;
    }

    public void setMat_lot(String mat_lot) {
        this.mat_lot = mat_lot;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getQty_str() {
        return qty_str;
    }

    public void setQty_str(String qty_str) {
        this.qty_str = qty_str;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    @Override
    public String toString() {
        return "ZX{" +
                "serial_no=" + serial_no +
                ", start_date=" + start_date +
                ", exp_date='" + exp_date + '\'' +
                ", mat_lot='" + mat_lot + '\'' +
                ", qty='" + qty + '\'' +
                ", barcode='" + barcode + '\'' +
                ", month=" + month +
                ", qty_str='" + qty_str + '\'' +
                ", type_id='" + type_id + '\'' +
                ", mat_code='" + mat_code + '\'' +
                ", batch='" + batch + '\'' +
                '}';
    }
}
