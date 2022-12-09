package srl.neotech.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestComponentUtente {

	@Autowired
	private TestComponentInventario inventario;

	public TestComponentInventario getInventario() {
		return inventario;
	}

	public void setInventario(TestComponentInventario inventario) {
		this.inventario = inventario;
	}
}
