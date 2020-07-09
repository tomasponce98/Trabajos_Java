package ui;


import java.util.LinkedList;
import java.util.Scanner;

import entities.*;
import logic.Login;

public class Menu {
	Scanner s=null;
	Login ctrlLogin = new Login();

	public void start() {
		s = new Scanner(System.in);
		Persona p=login();
		System.out.println("Bienvenido "+p.getNombre()+" "+p.getApellido());
		System.out.println();
		
		String command;
		do {
			command=getCommand();
			executeCommand(command);
			System.out.println();
			
		}while(!command.equalsIgnoreCase("exit"));
		
		s.close();
	}

	private void executeCommand(String command) {
		switch (command) {
		case "list":
			System.out.println(ctrlLogin.getAll());
			break;
		case "find":
			System.out.println(find());
			break;
		case "search":
			System.out.println(search());
	
			break;
		case "new":
			nuevo();
			
			break;
		case "edit":
			edit();
			
			break;
		case "delete":
			delete();
			
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando segÃºn la opciÃ³n que desee realizar");
		System.out.println("list\t\tlistar todos");
		System.out.println("find\t\tbuscar por tipo y nro de documento"); //solo debe devolver 1
		System.out.println("search\t\tlistar por apellido"); //puede devolver varios
		System.out.println("new\t\tcrea una nueva persona y asigna un rol existente");
		System.out.println("edit\t\tbusca por tipo y nro de documento y actualiza todos los datos");
		System.out.println("delete\t\tborra por tipo y nro de documento");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	public Persona login() {
		Persona p=new Persona();
		
		System.out.print("Email: ");
		p.setEmail(s.nextLine());

		System.out.print("password: ");
		p.setPassword(s.nextLine());
		
		p=ctrlLogin.validate(p);
		
		return p;
		
	}
	
	private Persona find() {
		System.out.println();
		Persona p=new Persona();
		Documento d=new Documento();
		p.setDocumento(d);
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());

		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());
		
		return ctrlLogin.getByDocumento(p);
	}
	
	private LinkedList<Persona> search() {
		System.out.println();
		Persona p=new Persona();
		System.out.print("Apellido:  ");
		p.setApellido(s.nextLine());
		
		return ctrlLogin.getByApellido(p);
	}
	
	private void nuevo()
	{
		System.out.println();
		Persona p=new Persona();
		Documento d=new Documento();
		Rol r=new Rol();
		System.out.println("Ingrese tipo doc: ");
		d.setTipo(s.nextLine());
		System.out.println("Ingrese numero doc: ");
		d.setNro(s.nextLine());
		p.setDocumento(d);
		System.out.println("Ingrese nombre: ");
		p.setNombre(s.nextLine());
		System.out.println("Ingrese apellido: ");
		p.setApellido(s.nextLine());
		System.out.println("Ingrese email: ");
		p.setEmail(s.nextLine());
		System.out.println("Ingrese telefono: ");
		p.setTel(s.nextLine());
		System.out.println("Esta habilitado:? 1=si ,0=no");
		if(s.nextLine()=="1") {
		p.setHabilitado(true);
	}
		else {
			p.setHabilitado(false);
		}
		
		System.out.println("Ingrese contraseña: ");
		p.setPassword(s.nextLine());
		
		System.out.println("Ingrese el id de rol: ");
		int id_rol=Integer.parseInt(s.nextLine());
		r.setId(id_rol);
		r.setDescripcion(ctrlLogin.getById(r).getDescripcion());
		
		ctrlLogin.add(p);
		ctrlLogin.addRol_Persona(p,r);
		
		//agregue el metodo addRol_Persona en persona debido a que crei que era el mejor lugar para agregarlo.
		
		
	}
	
	private void delete()
	{
		Persona p=find();
		ctrlLogin.deleteRol_Persona(p);
		ctrlLogin.delete(p);
		//Aca tuve que hacer un delete en rol_persona y persona,  debido a que no podia solo eliminar
		//en persona debido a que depende rol_persona depende de la clave  foranea de persona
	}
	
	private void edit()
	{
		System.out.println();
		Persona p=new Persona();
		Documento d=new Documento();
		Rol r=new Rol();
		System.out.println("Ingrese tipo doc: ");
		d.setTipo(s.nextLine());
		System.out.println("Ingrese numero doc: ");
		d.setNro(s.nextLine());
		p.setDocumento(d);
		System.out.println("Ingrese nuevo nombre: ");
		p.setNombre(s.nextLine());
		System.out.println("Ingrese nuevo apellido: ");
		p.setApellido(s.nextLine());
		System.out.println("Ingrese nuevo email: ");
		p.setEmail(s.nextLine());
		System.out.println("Ingrese nuevo telefono: ");
		p.setTel(s.nextLine());
		System.out.println("Esta habilitado:? 1=si ,0=no");
		if(s.nextLine()=="1") {
		p.setHabilitado(true);
	}
		else {
			p.setHabilitado(false);
		}
		
		System.out.println("Ingrese nueva contraseña: ");
		p.setPassword(s.nextLine());
		
		ctrlLogin.update(p);
	
	}
	//Aca solo hago un update de persona,no realice el update de rol_persona porque no especifica
}