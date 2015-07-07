package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the SCORECALCULATOR database table.
 * 
 */
@Entity
@Table(name="SCORECALCULATOR", schema = "GUITARSHOP3")
@NamedQuery(name="Scorecalculator.findAll", query="SELECT s FROM Scorecalculator s")
public class Scorecalculator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	
	private long serialnumber;

	private BigDecimal testscore;

	public Scorecalculator() {
	}

	public long getSerialnumber() {
		return this.serialnumber;
	}

	public void setSerialnumber(long serialnumber) {
		this.serialnumber = serialnumber;
	}

	public BigDecimal getTestscore() {
		return this.testscore;
	}

	public void setTestscore(BigDecimal testscore) {
		this.testscore = testscore;
	}

}