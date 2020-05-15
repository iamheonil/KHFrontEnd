package dto;

import java.util.Date;

public class Emp {

	// 대문자 -> 소문자 변경 단축키 Ctrl + Shift + Y
	// 맥 -> Commnand + Shift + Y
	
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate; // Date 는 java.util.Date 사용할 것.
	private double sal; // NUMBER(7,2) -> 5자리의 정수, 둘째자리까지 소수
	private double comm; // NUMBER(7,2) -> 5자리의 정수, 둘째자리까지 소수
	private int deptno;
	
	
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
				+ ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}


	public int getEmpno() {
		return empno;
	}


	public void setEmpno(int empno) {
		this.empno = empno;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public int getMgr() {
		return mgr;
	}


	public void setMgr(int mgr) {
		this.mgr = mgr;
	}


	public Date getHiredate() {
		return hiredate;
	}


	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}


	public double getSal() {
		return sal;
	}


	public void setSal(double sal) {
		this.sal = sal;
	}


	public double getComm() {
		return comm;
	}


	public void setComm(double comm) {
		this.comm = comm;
	}


	public int getDeptno() {
		return deptno;
	}


	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	

}
