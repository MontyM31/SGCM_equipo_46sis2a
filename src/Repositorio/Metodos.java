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
	
	public ArrayList<Paciente> getHistorialC(int nss, String nombre_pac, String appat_pac , String apmat_pac, String fechanac_pac){
		AccionesPaciente repository = new AccionesPaciente();
		return repository.getHistorialC(nss, nombre_pac, appat_pac, apmat_pac, fechanac_pac);
	}

}
