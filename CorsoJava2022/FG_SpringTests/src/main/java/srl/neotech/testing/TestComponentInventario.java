package srl.neotech.testing;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class TestComponentInventario {
	
	private Integer valoreInventario=0;
	private String codiceInventario;
	private ArrayList<TestComponentOggetto> listaInventario;
	
	public TestComponentInventario(){
		 this.setListaInventario(new ArrayList<TestComponentOggetto>());
	}
	
	
	
	public Integer getValoreInventario() {
		return valoreInventario;
	}
	public void setValoreInventario(Integer valoreInventario) {
		this.valoreInventario = valoreInventario;
	}
	public String getCodiceInventario() {
		return codiceInventario;
	}
	public void setCodiceInventario(String codiceInventario) {
		this.codiceInventario = codiceInventario;
	}



	public ArrayList<TestComponentOggetto> getListaInventario() {
		return listaInventario;
	}



	public void setListaInventario(ArrayList<TestComponentOggetto> listaInventario) {
		this.listaInventario = listaInventario;
	}


	
	
}
