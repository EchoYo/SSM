package com.echo.model;

import java.io.Serializable;

/**
 * <p>Description:请假类型</p>
 * Created by Echoj on 2016-09-01.
 */
public class HrResultType implements Serializable {
    private int id;
    private String resultType;
    private String resultName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }
}
