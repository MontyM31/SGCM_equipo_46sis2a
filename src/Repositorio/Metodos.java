package Repositorio;

import java.util.ArrayList;

import Control.AccionesPaciente;
import Modelo.Paciente;
import Modelo.Personal;

public class Metodos {
	
	public ArrayList<Personal> getNombreyApellidoPer(String nombre, String apePatPer) {
		AccionesPaciente repository = new AccionesPaciente();
		return repository.getNombreyApellidoPer(nombre, apePatPer);
	}

}
