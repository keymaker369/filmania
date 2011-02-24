package org.seke.filmania.domain;

import javax.persistence.ManyToOne;

public class Rating {
	@ManyToOne
	private User user;
	@ManyToOne
	private Movie movie;
	private int value;
}
