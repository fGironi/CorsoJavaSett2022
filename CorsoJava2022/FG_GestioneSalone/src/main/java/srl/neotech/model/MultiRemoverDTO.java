package srl.neotech.model;

import java.util.ArrayList;

public class MultiRemoverDTO {

	private ArrayList<String> removeIdList;

	
	public MultiRemoverDTO() {
		super();
		this.removeIdList = new ArrayList<String>();
	}
	
	public ArrayList<String> getRemoveIdList() {
		return removeIdList;
	}

	public void setRemoveIdList(ArrayList<String> removeIdList) {
		this.removeIdList = removeIdList;
	}
}
