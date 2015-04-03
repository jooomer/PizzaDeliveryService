package ua.epam.rd.domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Embeddable
public class Souce {
	
	private String souce;

	public String getSouce() {
		return souce;
	}

	public void setSouce(String souce) {
		this.souce = souce;
	}
}
