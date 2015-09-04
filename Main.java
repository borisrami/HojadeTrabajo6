/* @author Universidad del Valle de Guatemala
 * @author Bryan Chan  Carnet: 14469
 * @author Boris Cifuentes Carnet: 14150
 */

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Bienvenido a la hoja de trabajo 6");
		SetFactory<String> setFactory = new SetFactory<String>();
		
		System.out.println("1.HashSet\n2.TreeSet\n3.LinkedHashSet\nSeleccione una implementacion para los sets: ");
		int setseleccion = scanner.nextInt();

		Set<String> java = setFactory.getSet(setseleccion);
		Set<String> web = setFactory.getSet(setseleccion);
		Set<String> celulares = setFactory.getSet(setseleccion);
		
		boolean continuar = true;
		int seleccion;
		String nombre;
		/*
		 * variables para definir si una persona debe ser ingresada a un conjunto.
		 */
		boolean bjava;
		boolean bweb;
		boolean bcelulares;
		while(continuar){
			System.out.println("Ingrese el nombre de la persona: ");
			nombre = scanner.next();
			System.out.println("Posee experiencia en desarrollo Java?\n1.Si\n2.No\nSeleccione una opcion: ");
			seleccion = scanner.nextInt();
			if(seleccion==1){
				bjava = true;
			} else {
				bjava = false;
			}
			
			System.out.println("Posee experiencia en desarrollo Web?\n1.Si\n2.No\nSeleccione una opcion: ");
			seleccion = scanner.nextInt();
			if(seleccion==1){
				bweb = true;
			} else {
				bweb = false;
			}
			
			System.out.println("Posee experiencia en desarrollo celular?\n1.Si\n2.No\nSeleccione una opcion: ");
			seleccion = scanner.nextInt();
			if(seleccion==1){
				bcelulares = true;
			} else {
				bcelulares = false;
			}
			
			if(bjava){
				java.add(nombre);
			}
			if(bweb){
				web.add(nombre);
			}
			if(bcelulares){
				celulares.add(nombre);
			}
			
			System.out.println("Desea ingresar a otra persona?\n1.Si\n2.No\nSeleccione una opcion: ");
			seleccion = scanner.nextInt();
			if(seleccion==1){
				continuar = true;
			} else {
				continuar = false;
			}
		}
		
		scanner.close();
		
		//Se crean los iteradores
		Set<String> resultado = setFactory.getSet(setseleccion);
		Iterator<String> javaIterator = java.iterator();
		Iterator<String> webIterator = web.iterator();
		Iterator<String> celularesIterator = celulares.iterator();
		
		/*
		System.out.println("JAVA");
		while(javaIterator.hasNext()){
			System.out.println(javaIterator.next());
		}
		System.out.println("WEB");
		while(webIterator.hasNext()){
			System.out.println(webIterator.next());
		}
		System.out.println("CELULARES");
		while(celularesIterator.hasNext()){
			System.out.println(celularesIterator.next());
		}
		*/
		
		
		//Personas con experiencia en java, web y celulares
		while(javaIterator.hasNext()){
			String javaElement = javaIterator.next();
			if(web.contains(javaElement)&&celulares.contains(javaElement)){
				resultado.add(javaElement);
			}
		}
		System.out.println("Personas con experiencia en java, web y celulares");
		Iterator<String> resultadoIterator = resultado.iterator();
		while(resultadoIterator.hasNext()){
			System.out.println(resultadoIterator.next());
		}
		//Se resetea el set resultado
		resultado.clear();
		
		//Personas con experiencia en java pero no en web
		javaIterator = java.iterator();
		while(javaIterator.hasNext()){
			String javaElement = javaIterator.next();
			if(!web.contains(javaElement)){
				resultado.add(javaElement);
			}
		}
		System.out.println("Personas con experiencia en java, pero no en web");
		resultadoIterator = resultado.iterator();
		while(resultadoIterator.hasNext()){
			System.out.println(resultadoIterator.next());
		}

		//Se resetea el set resultado
		resultado.clear();
		
		//Personas con experiencia en web y celulares, pero no en java
		webIterator = web.iterator();
		while(webIterator.hasNext()){
			String webElement = webIterator.next();
			if(celulares.contains(webElement)&&(!java.contains(webElement))){
				resultado.add(webElement);
			}
		}
		System.out.println("Personas con experiencia en web y celulares, pero no en java");
		resultadoIterator = resultado.iterator();
		while(resultadoIterator.hasNext()){
			System.out.println(resultadoIterator.next());
		}

		//Se resetea el set resultado
		resultado.clear();
		//Personas con experiencia en web o celulares, pero no en java
		webIterator = web.iterator();
		celularesIterator = celulares.iterator();
		while(webIterator.hasNext()){
			String webElement = webIterator.next();
			if((!java.contains(webElement))&&(!resultado.contains(webElement))){
				resultado.add(webElement);
			}
		}
		while(celularesIterator.hasNext()){
			String celularesElement = celularesIterator.next();
			if((!java.contains(celularesElement))&&(!resultado.contains(celularesElement))){
				resultado.add(celularesElement);//no contiene
			}
		}
		System.out.println("Personas con experiencia en web o celulares, pero no en java");
		resultadoIterator = resultado.iterator();
		while(resultadoIterator.hasNext()){
			System.out.println(resultadoIterator.next());
		}
		
		
		int contador=0;
		while(javaIterator.hasNext()){
			String javaElement= javaIterator.next();
			if(web.contains(javaElement)){
				contador += 1;
				
			}
			
			if(java.size()==contador&& web.size()>java.size()){
				System.out.println("Es un Subconjunto");
			}else{
				System.out.println("No es un Subconjunto");
			}
			
			
		}
		
		
		if(java.size()>web.size() && java.size()>celulares.size()){
			
			System.out.println("El grupo con mas grandes cantidad de desarrolladores es java.");
			Iterator<String> mayor = java.iterator();
			while(mayor.hasNext()){
				System.out.println(mayor.next());	
			}
			
			System.out.println("Ordenados:");
			mayor = java.iterator();
			Set<String> ordenamiento= new TreeSet<String>();
			while(mayor.hasNext()){
					ordenamiento.add(mayor.next());	
			}
			
			Iterator<String> orden = ordenamiento.iterator();
			while(orden.hasNext()){
				System.out.println(orden.next());	
			}
			
		}
		
		if(web.size()>java.size() && web.size()>celulares.size()){
			
			System.out.println("El grupo con mas grandes cantidad de desarrolladores es web.");
			Iterator<String> mayor = web.iterator();
			while(mayor.hasNext()){
				System.out.println(mayor.next());
			}
			
			System.out.println("Ordenados:");
			
			mayor = java.iterator();
			Set<String> ordenamiento= new TreeSet<String>();
			while(mayor.hasNext()){
				ordenamiento.add(mayor.next());
			}
			Iterator<String> orden = ordenamiento.iterator();
			while(orden.hasNext()){
				System.out.println(orden.next());	
			}
					
		}
		
		if(celulares.size()>java.size() && celulares.size()>web.size()){
			
			System.out.println("El grupo con mas grandes cantidad de desarrolladores es celulares.");
			Iterator<String> mayor = celulares.iterator();
			while(mayor.hasNext()){
				System.out.println(mayor.next());
			}
			
			System.out.println("Ordenados:");
			
			
			mayor = java.iterator();
			Set<String> ordenamiento= new TreeSet<String>();
			while(mayor.hasNext()){
				ordenamiento.add(mayor.next());
			}
			
		
			
			Iterator<String> orden = ordenamiento.iterator();
			while(orden.hasNext()){
				System.out.println(orden.next());	
			}
					
		}	
	}	
}