package Modelo;

public class Paciente {
	
	private int  expclinico,id_usuario,nss;
	private String nombre_pac, appat_pac, apmat_pac,tel_pac, CURP, pass; 
	private String fecha_cita,hora_cita,user, privilegio,fechanac_pac, DOireccion, Tipo_genero;
	
	private int getExpclinico() {
		return expclinico;
	}
	public void setExpclinico(int expclinico) {
		this.expclinico = expclinico;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getNss() {
		return nss;
	}
	public void setNss(int nss) {
		this.nss = nss;
	}
	public String getNombre_pac() {
		return nombre_pac;
	}
	public void setNombre_pac(String nombre_pac) {
		this.nombre_pac = nombre_pac;
	}
	
	public String getAppat_pac() {
		return appat_pac;
	}
	public void setAppat_pac(String appat_pac) {
		this.appat_pac = appat_pac;
	}
	
	public String getTipo_genero() {
		return Tipo_genero;
	}
	public void setTipo_genero(String tipo_genero) {
		Tipo_genero = tipo_genero;
	}
	
	public String getApmat_pac() {
		return apmat_pac;
	}
	public void setApmat_pac(String apmat_pac) {
		this.apmat_pac = apmat_pac;
	}
	public String getTel_pac() {
		return tel_pac;
	}
	public void setTel_pac(String tel_pac) {
		this.tel_pac = tel_pac;
	}
	public String getCURP() {
		return CURP;
	}
	public void setCURP(String CURP) {
		CURP = CURP;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getFecha_cita() {
		return fecha_cita;
	}
	public void setFecha_cita(String fecha_cita) {
		this.fecha_cita = fecha_cita;
	}
	public String getHora_cita() {
		return hora_cita;
	}
	public void setHora_cita(String hora_cita) {
		this.hora_cita = hora_cita;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPrivilegio() {
		return privilegio;
	}
	public void setPrivilegio(String privilegio) {
		this.privilegio = privilegio;
	}
	public String getFechanac_pac() {
		return fechanac_pac;
	}
	public void setFechanac_pac(String fechanac_pac) {
		this.fechanac_pac = fechanac_pac;
	}
	public String getDOireccion() {
		return DOireccion;
	}
	public void setDOireccion(String dOireccion) {
		DOireccion = dOireccion;
	}
	
	
	
	
}