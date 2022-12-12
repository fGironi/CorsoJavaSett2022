package srl.neotech.testing;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class TestComponentInventario {
	
	private Integer valoreInventario=0;
	private String codiceInventario;
	private ArrayList<TestModelOggetto> listaInventario;
	
	public TestComponentInventario(){
		 this.setListaInventario(new ArrayList<TestModelOggetto>());
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



	public ArrayList<TestModelOggetto> getListaInventario() {
		return listaInventario;
	}



	public void setListaInventario(ArrayList<TestModelOggetto> listaInventario) {
		this.listaInventario = listaInventario;
	}


	
	
}
