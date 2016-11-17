package com.echo.model;

import java.io.Serializable;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-08-10.
 */
public class HrRecShiftVo implements Serializable {
    private Long id;
    private String empId;
    private String shiftId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }


    @Override
    public String toString() {
        return "HrRecShiftVo{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", shiftId='" + shiftId + '\'' +
                '}';
    }
}
