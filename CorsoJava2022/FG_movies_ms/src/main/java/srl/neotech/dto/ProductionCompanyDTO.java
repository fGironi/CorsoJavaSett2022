package srl.neotech.dto;

public class ProductionCompanyDTO {

	private Integer id;
    private String companyName;
    
	public ProductionCompanyDTO() {
	}

	public ProductionCompanyDTO(Integer id, String companyName) {
		this.id = id;
		this.companyName = companyName;
	}
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	

    
    
}
