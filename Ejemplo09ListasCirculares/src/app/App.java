package app;

import circularlist.CircularList;
import node.node;

public class App {

	public static <T> void main(String[] args) {
		CircularList<String> names    = new CircularList<>();	
		names.addFirst("Abraham");
		names.addFirst("Daniel");
		names.addEnd("Eduardo");
		names.addFirst("Laura");
		names.addFirst("Luis");
		names.addEnd("Gerardo");
		names.addFirst("Ricardo");
		names.addFirst("Yarely");
		System.out.println("---------Lista----------");
		names.pronter();
		System.out.println("------Remove(removemos a Daniel)-------");
		names.remove("Daniel");
		System.out.println("");
		names.pronter();
		System.out.println("------Get Last-------");
		node<T> name=(node <T>) names.getLast();
		if(name!=null)
		System.out.println(name.getValue());
		System.out.println("------Get First-------");
		node<T> namse=(node <T>) names.getFirst();
		if(namse!=null)
		System.out.println(namse.getValue());
		System.out.println("-------Search(buscamos a Laura)-------");
		name=(node<T>) names.Search("Laura");
		if(name!=null){
			System.out.println(name.getValue());
		}else{
			System.out.println("Nombre no encontrado");
		}
		System.out.println("-------Is Empty-------");
		names.isEmpty();
		
		boolean resp=names.isEmpty();
		if(resp)
			System.out.println("Lista vacia");
		else
			System.out.println("La lista contiene datos");

		System.out.println("-------Search  Before--------");
		name=(node<T>) names.SearchBefore("Laura");
		if(name!=null){
			System.out.println(name.getValue());
		}else{
			System.out.println("Nombre no encontrado");
		}
		System.out.println("-------Remove First--------");
		names.removefirst();
		names.pronter();
		System.out.println("-------Remove Last---------");
		names.removelast();
		names.pronter();
		System.out.println("-------Reindex---------");
		names.reindex();
		System.out.println("-------Indexof (en este caso Laura)---------");
		System.out.println("La posicion es: "+names.indexof("Laura"));
		System.out.println("-------Size---------");
		names.size();
		System.out.println("-------Remove Before(remover antes de ricardo)---------");
		names.removebefore("Ricardo");
		names.pronter();
		System.out.println("-------Remove After(remover despues de abraham)---------");
		names.removeafter("Abraham");
		names.pronter();
		System.out.println("-------Replace(Laura por Angelica)-------");
		names.replace("Laura", "Angelica");
		names.pronter();
		System.out.println("-------Clear--------");
		names.clear();
	
		boolean resp2=names.isEmpty();
		if(resp2)
			System.out.println("Lista vacia");
		else
			System.out.println("La lista contiene datos");

		names.pronter();
	
	
	}

}

/*
 * Replace 			*******************
 * Clear			*******************
 * isempty   		*******************
 * getfist           ******************
 * getlast           ******************
 * removefirst   	*******************
 * removelast    	*******************
 * size         	*******************
 * removeafter 		*******************
 * removebefore   	*******************
 * indexof           ******************
 * reindex           ******************
 */





