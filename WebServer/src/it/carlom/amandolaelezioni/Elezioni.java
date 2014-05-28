package it.carlom.amandolaelezioni;

import java.util.ArrayList;

public class Elezioni {

	private static Elezioni singleton;

	private Sezione sezione1;
	private Sezione sezione2;
	private Sezione sezione3;
	private Sezione sezione4;
	private long lastupdate;

	public ArrayList<Sezione> sezioni;
	
	private Elezioni() {

		sezione1 = new Sezione(1);
		sezione2 = new Sezione(2);
		sezione3 = new Sezione(3);
		sezione4 = new Sezione(4);

		sezioni = new ArrayList<Sezione>();
		sezioni.add(sezione1);
		sezioni.add(sezione2);
		sezioni.add(sezione3);
		sezioni.add(sezione4);
	}

	public static Elezioni getElezioni(){
		if(singleton == null){
			singleton = new Elezioni();
		}
		
		return singleton;
	}
	
	public void updateTime(){
		lastupdate = System.currentTimeMillis();
	}
}
