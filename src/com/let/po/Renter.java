package com.let.po;

import java.util.Set;

public class Renter extends Person {
	private Set<LetInfo> letInfos;// 租客1:租房信息n

	public Set<LetInfo> getLetInfos() {
		return letInfos;
	}

	public void setLetInfos(Set<LetInfo> letInfos) {
		this.letInfos = letInfos;
	}

}
