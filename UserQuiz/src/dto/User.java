package dto;

public class User {

	private int idx;
	private String userid;
	private String name;

	

	@Override
	public String toString() {
		return "User [idx=" + idx + ", userid=" + userid + ", name=" + name + "]";
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
