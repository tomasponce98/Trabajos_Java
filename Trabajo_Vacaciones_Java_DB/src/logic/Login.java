package logic;

import java.util.LinkedList;

import data.*;
import entities.*;

public class Login {
	private DataPersona dp;
	private DataRol dr;
	
	public Login() {
		dp=new DataPersona();
		dr=new DataRol();
	}
	
	public Persona validate(Persona p) {
		/* para hacer más seguro el manejo de passwords este sería un lugar 
		 * adecuado para generar un hash de la password utilizando un cifrado
		 * asimétrico como sha256 y utilizar el hash en lugar de la password en plano 
		 */
		return dp.getByUser(p);
	}

	public LinkedList<Persona> getAll(){
		return dp.getAll();
	}

	public Persona getByDocumento(Persona per) {
		return dp.getByDocumento(per);
		
	}
	
	public LinkedList<Persona> getByApellido(Persona per) {
		return dp.getByApellido(per);
	}
	
	public void add(Persona p) {
		dp.add(p);
	}
	
	public void addRol_Persona(Persona p, Rol r)
	{
		dp.addRol_Persona(p, r);
	}
	
	public Rol getById(Rol rolToSearch) {
		return dr.getById(rolToSearch);
	}
	
	public void deleteRol_Persona(Persona p)
	{
		dp.deleteRol_Persona(p);
	}
	
	public void delete(Persona p)
	{
		dp.delete(p);
	}
	
	public void update(Persona p)
	{
		dp.update(p);
	}

}
