package net.cqwu.protopyte;

import java.io.Serializable;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.protopyte
 *
 * @author： Administrator
 * Create Date：  2018-05-08
 * Modified By：   Administrator
 * Modified Date:  2018-05-08
 * Why & What is modified
 * Version:        V1.0
 */
public class WorkExperience implements Cloneable,Serializable {
    private String workDate;
    private String workCompany;

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getWorkCompany() {
        return workCompany;
    }

    public void setWorkCompany(String workCompany) {
        this.workCompany = workCompany;
    }

    @Override
    protected WorkExperience clone() throws CloneNotSupportedException {
        return (WorkExperience)super.clone();
    }
}
