package dto;

public class Doctor {

	private int doccode;
	private String docname;
	private int depcode;

	@Override
	public String toString() {
		return "Doctor [doccode=" + doccode + ", docname=" + docname + ", depcode=" + depcode + "]";
	}

	public int getDoccode() {
		return doccode;
	}

	public void setDoccode(int doccode) {
		this.doccode = doccode;
	}

	public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public int getDepcode() {
		return depcode;
	}

	public void setDepcode(int depcode) {
		this.depcode = depcode;
	}

}
