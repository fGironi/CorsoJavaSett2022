package passatempo.cards;
import java.util.ArrayList;

public class Giocatore {
	
	private int id;
	private String nome;
	private Integer punti;
	private ArrayList<Carta> mano;
	private ArrayList<Carta> prese;
	
	public Giocatore(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
		this.prese=new ArrayList<Carta>();
		this.setPunti(0);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Carta> getMano() {
		return mano;
	}
	public void setMano(ArrayList<Carta> mano) {
		this.mano = mano;
	}
	
	public ArrayList<Carta> getPrese() {
		return prese;
	}
	public void setPrese(ArrayList<Carta> prese) {
		this.prese = prese;
	}
	public Integer getPunti() {
		return punti;
	}
	public void setPunti(Integer punti) {
		this.punti = punti;
	}

	
	
	public ArrayList<Carta> PescaIniziale(ArrayList<Carta> mazzo) {
		this.mano = new ArrayList<Carta>();
		for (int i=0; i<3; i++) {
			Carta c= new Carta();
			c= mazzo.get(0);
			this.mano.add(c);
			//System.out.println("pescato"+c.getValore()+c.getSeme());
			mazzo.remove(0);
			}
		return mazzo;
		
	}
	
	public void Gioca(ArrayList<Carta> mano, ArrayList<Carta> cartePerTerra) {
		this.getMano().get(0);
		System.out.println(this.getNome()+" gioca "+this.getMano().get(0).getValore()+" di "+this.getMano().get(0).getSeme());
		boolean presaFatta=false;
		for (Carta c:cartePerTerra) {
			if (this.getMano().get(0).getValore()==c.getValore()) {
				System.out.println(this.getNome()+" prende "+c.getValore()+" di "+c.getSeme()+" da terra");
				this.getPrese().add(c);
				this.getPrese().add(this.getMano().get(0));
				this.getMano().remove(0);
				cartePerTerra.remove(c);
				presaFatta=true;
				if(cartePerTerra.size()==0) {System.out.println("Scopa! punto per "+this.getNome()); this.punti++;}
				break;
				}
			}
		
		if (presaFatta==false) {
			System.out.println(this.getNome()+" non prende nulla");
			cartePerTerra.add(this.getMano().get(0));
			this.getMano().remove(0);
			}
		System.out.println();
		
	}

	

}
