package com.let.po;

import java.util.Set;

public class Renter extends Person {
	private Set<LetInfo> letInfos;// ���1:�ⷿ��Ϣn

	public Set<LetInfo> getLetInfos() {
		return letInfos;
	}

	public void setLetInfos(Set<LetInfo> letInfos) {
		this.letInfos = letInfos;
	}

}
