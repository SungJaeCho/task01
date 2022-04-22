package com.example.task01.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dept")
@Entity
public class Dept {

    @Id @GeneratedValue
    private Long deptno; // 부서ID
    private String dname; // 부서명
    private String ioc; // 부서위치

    public Dept(final Long deptno, final String dname, final String ioc) {
        this.deptno = deptno;
        this.dname = dname;
        this.ioc = ioc;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setIoc(String ioc) {
        this.ioc = ioc;
    }

    public Long getDeptno() {
        return deptno;
    }

    public String getDname() {
        return dname;
    }

    public String getIoc() {
        return ioc;
    }
}
