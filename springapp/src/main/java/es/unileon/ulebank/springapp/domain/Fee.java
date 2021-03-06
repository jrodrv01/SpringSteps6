// default package
// Generated 28-jun-2014 19:19:57 by Hibernate Tools 4.0.0
package es.unileon.ulebank.springapp.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Fees generated by hbm2java
 */
@Entity
@Table(name = "fees", catalog = "springapp")
public class Fee implements java.io.Serializable {

	private int id;
	private String description;
	private BigDecimal fee;
	private String idAccount;

	public Fee() {
	}

	public Fee(int id) {
		this.id = id;
	}

	public Fee(int id, String description, BigDecimal fee, String idAccount) {
		this.id = id;
		this.description = description;
		this.fee = fee;
		this.idAccount = idAccount;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "fee", precision = 15)
	public BigDecimal getFee() {
		return this.fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	@Column(name = "idAccount", length = 20)
	public String getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(String idAccount) {
		this.idAccount = idAccount;
	}

}
