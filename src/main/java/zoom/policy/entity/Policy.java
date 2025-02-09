package zoom.policy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "POLICY")
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int policyNumber;
	
	private int exporterCode;

	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	public int getExporterCode() {
		return exporterCode;
	}

	public void setExporterCode(int exporterCode) {
		this.exporterCode = exporterCode;
	}

	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Policy(int policyNumber, int exporterCode) {
		super();
		this.policyNumber = policyNumber;
		this.exporterCode = exporterCode;
	}

	@Override
	public String toString() {
		return "Policy [policyNumber=" + policyNumber + ", exporterCode=" + exporterCode + "]";
	}
	
	
	
}
