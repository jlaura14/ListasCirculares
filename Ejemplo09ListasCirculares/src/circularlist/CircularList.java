package circularlist;

import node.node;

public class CircularList <T> {

	private node<T> sentinel = null;
	private node<T> actual = null;
	
	public CircularList() {
		sentinel = new node<T>();
		actual   = new node<T>();
		sentinel.setIndex(-1);
		actual.setIndex(-1);
	}
	
	public CircularList(T value) {
		this();
		sentinel.setNext(new node<T>(value));
		actual = sentinel.getNext();
		sentinel.getNext().setNext(actual);
	}


	public void addFirst(T value) {
		node<T> nuevo = new node<T>(value); //creamos una variable tipo nodo donde guardaremos el nuevo valor
		node<T> last = getLast();			//guardamos en una variable el nodo en la ultima posicion
		
		if(isEmpty()){//si la lista esta vacio
			sentinel.setNext(nuevo);//el next del sentinel sera igual al nuevo valor
			nuevo.setNext(nuevo);//y el set next del nuevo sera ese mismo de esta manera formamos una lista circular
		}else{//si no	
			nuevo.setNext(sentinel.getNext());//el nuevo valor estara en la posicion del next del sentinel
			sentinel.setNext(nuevo);// sentinel.setnext tendra el nuevo valor que le asignamos
			last.setNext(nuevo);//el valor en la posicion final de la lista en su next tendra el nuevo valor asignado.
		}
	}

	public node<T> getLast(){
		node<T> tmp = sentinel.getNext(); //creamos un temporal que sera igual al sentinel.getnext
		if(!isEmpty()){//si no esat vacia iniciamos el while mientras sea diferente a 
			while(!sentinel.getNext().equals(tmp.getNext()))//el valor de sentinel en su next es igual a tmp en su next
				tmp = tmp.getNext();//entonces tmp avanzara una posicion
			return tmp;//returnamos tmp
		}
		return null;// returnamos nulo si la lista esta vacia
	}

	public boolean remove(T value){
		if(!isEmpty()){//si la no esta vacia
			node<T> found = Search(value);// creamos una variable donde guadamos el valor que ya encontramos en el metodo Search
			if(found != null){ //si el valor es diferente a nulo
				node<T> tmp = SearchBefore(value, sentinel.getNext()); // creamos un tmp para buscar el anterior del valor antes buscado
				if(tmp.equals(tmp.getNext()))//si tmp es igual a tmp.getnext
					sentinel.setNext(null);//entonces sentinel en su next sera igual a nulo
				else if(sentinel.getNext().equals(found)){//si no creamos otro if donde decimos,si sentinel.getnext es igual al primer valor buscado
					 sentinel.setNext(found.getNext());//entonces sentinel en su next sera igual a found en su next
					 tmp.setNext(found.getNext());//y tmp en su next sera igual a found en su next
				 }else{//si no 
					 tmp.setNext(found.getNext());// tmp en su next sera igual a found.getnext
				 }
			}
		}
		return true;//returnamos true si esta vacia 
	}

	public node<T> SearchBefore(T value){
		return SearchBefore(value,sentinel.getNext());
	}
	
	private node<T> SearchBefore(T value, node<T> list){
		if(list.getNext().getValue().equals(value)){
			return list;
		}
		if(list.getNext().equals(sentinel.getNext())){
			return null;
		}
		return SearchBefore(value, list.getNext());
	}

	public node<T> Search(T value){
		return (!isEmpty())?Search(value, sentinel.getNext()):null;
	}

	private node<T> Search(T value, node<T> list){
		if(list.getNext().getValue().equals(value)){
			return list.getNext();
		}
		if(list.getNext().equals(sentinel.getNext())){
			return null;
		}
		
		return Search(value, list.getNext());
	}

	public boolean isEmpty(){
		return (sentinel.getNext() == null)?true:false;// si sentinel en su next es igual a nulo returnamos que la lista es vacia
		//si es diferente a nulo la lista contiene datos
	}

	public void pronter() {
		node<T> tmp = sentinel.getNext();
		if(!isEmpty()){
			while (!tmp.getNext().equals(sentinel.getNext())) {
				System.out.println(tmp.getValue());
				tmp = tmp.getNext();
			}
			System.out.println(tmp.getValue());
		}
	}
	
	//////////////////////////////////////////////
	 public void clear(){
			sentinel.setNext(null);		//le damos un valor nulo al next del sentinel de esta manera borramos todos los datos
		 }
	 ////////////////////////////////////////////
	 
	 public void addEnd(T value) {
			node<T> nuevo = new node<T>(value);//guardamos en nuevo el valor que estamos recibiendo
			node<T> last = getLast();//creamos last para guardar el ultimo valor de la lista
			
			if(isEmpty()){//si la lista esta vacia
				sentinel.setNext(nuevo);// el setnext de sentinel tendra el nuevo valor 
				nuevo.setNext(nuevo);//y el nuevo valor en su setnext sera nuevo, de esta manera se crea la lista doble
			}else{
				nuevo.setNext(sentinel.getNext());//nuevo en su set next sera el getnext de sentinel
				
				last.setNext(nuevo);// y last en su setnext sera igual a nuevo
			}
		}
/////////////////////////////////////////////////////////
	 public node<T> getFirst(){
			node<T> tmp = sentinel.getNext();//creamos un temporal que sera igual al sentinel.getnext
			if(isEmpty()){//si la lista esta vacia 
					return null;//returnamos null
				}
			return tmp;// si no retornamos el valor de tmp
	 }
//////////////////////////////////////////////////////////
	 
	 public void removefirst() {
		 	node<T> last = getLast();//creamos last que sera igual al ultimo valor de la lista
			sentinel=sentinel.getNext();//sentinel sera igual a sentinel.getnext
			last.setNext(sentinel.getNext());// y last en su setnext sera igual a sentinel en su get next esto eliminara el primer valor de la lista
			
			//recorremos el sentinel para eliminar el primer nodo
		}
	/////////////////////////////////////////////////////
	 
		public boolean removelast(){
			node<T> last = getLast();//creamos last donde guardaremos el ultimo valor de la lista
			if(!isEmpty()){//si la lista no esta vacia 
				node<T> found = Search(last.getValue());//creamos found que sera igual al ultimo valor encontrado
				if(found != null){ //si el valor es diferente a nulo
					node<T> tmp = SearchBefore(last.getValue(), sentinel.getNext());//creamos tmp para buscar el valor anterior a last
					if(tmp.equals(tmp.getNext()))//si tmp es igual a tmp.getnext, es porque solo hay un valor y sentinel en su set next sera igual a nulo
						sentinel.setNext(null);//sentinel en su setnext sera igual a nulo
					else if(sentinel.getNext().equals(found)){//si no hacemos otro if, si sentinel.getnext es igual a found
						 sentinel.setNext(found.getNext());//sentinel.setn next sera igual a found.getnext
						 tmp.setNext(found.getNext());//y tmp en su setnext sera igual a found.getnext
					 }else{//si no
						 tmp.setNext(found.getNext());// tmp.setnext sera igual a found.getnext
					 }
				}
			}
			return true;//returnamos true si la lista esta vacia
		}
		////////////////////////////////////////////
		public void reindex() {
			int aux=1;	//creamos un contador = 1
			node<T> tmp = sentinel.getNext();// creamos tmp que sera igual a sentinel.getnext
		
			if(!isEmpty()){//si la lista no esta vacia
				while (!tmp.getNext().equals(sentinel.getNext())) {///mientras tmp.getnext() sea diferente a sentinel.getnext();
					System.out.println(aux +" "+ tmp.getValue());//imprimimos el contador mas el valor de temporal
					tmp.setIndex(aux);//tmp en su setindex sera igual al valor del contador
					tmp = tmp.getNext(); //temporal dara un salto
					aux++;//el contador aumentara mas 1
				}// y se repite el while
				System.out.println(aux+" "+tmp.getValue());//imprimimos el ultimo valor del reindex
			}
		}
	///////////////////////////////////////////
		
		public long indexof(T value)
		{
			node<T> temp= sentinel.getNext();				//creamos 	un temporal que sera igual a sentinel.getnext();
			while(!temp.getNext().equals(sentinel.getNext())){		//mientras temporal.getnext sea diferente a sentinel.getnext	
			if (temp.getNext().getValue().equals(value)){//Creamos un if, si el valor de temporal en su getnext es igual al valor 
				return temp.getIndex()+1;}		//retornamos el la posicion del valor buscado		
			else{
				temp=temp.getNext();					//si no temporal da un salto y se vuelve a repetir el while
			}
				
			}
			return 0;//returnamos 0 si no existe el valor 
		}
		/////////////////////////////////////////////
		public void size() {
			int aux=1;						//tenemos un auxiliar que nos ayudara a obtener la cantidad en la lista
			node<T> tmp = sentinel.getNext();			//creamos un temporal
			while (!tmp.getNext().equals(sentinel.getNext())) {//mientras temporal.getnext sea diferente a sentinel.getnext
				tmp = tmp.getNext();		//temporal avanzara una posicion
				tmp.setIndex(aux);
				aux++;//el auxiliar aumentara +1
			}
			System.out.println(aux); 		//Se muestra el total que se acumulo en el auxiliar
			System.gc();
			
		}
		////////////////////////////////////////////
	 public T removebefore(T value){
			 
			 return removebefore(value,sentinel); //recibimos un valor y retornamos el valor y el sentinel
			 
		 }
		 private T removebefore(T value, node<T> lista){//Recibimos el valor y el sentinel
			 node<T> tmp = lista;			//creamos un temporal de sentinel
			 
			 if(tmp.getNext()==null){		//si tmp.getnext es igual a nulo regresamos el valor que recibimos
				 return value;
			 }
			 if(lista.getNext().equals(value)){
				 removelast();
			 }
			 lista=lista.getNext();
			 if(lista.getNext().getValue().equals(value)){
				 tmp.setNext(tmp.getNext().getNext()); //cambiamos el valor del mnodo que esta anterior del lista 
			 }else{
				 return removebefore(value,lista); // regresamos para volver a recorrer
			 }
			 return value;
		 }
	 /////////////////////////////////////////////////////////
		 public void removeafter(T value)
			{
				if(!isEmpty())//si la lista no esta vacia 
				{
					node<T> tmp=Search(value);//creamos tmp que sera igual al valor encontrado
					if (tmp!=null)//si tmp es diferente a nulo
					{
						node<T> last = getLast();//creamos last que sera igual al ultimo valor de la lsita
						if(value.equals(last)){//si el valor es igual al ultimo entonces
							removefirst();//removemos a su after que es este caso seria el primer valor
						}
						if(tmp.getNext().equals(sentinel.getNext()))//si tmp en su getnext es igual a sentinel.getnext
						{
							tmp.setNext(tmp.getNext().getNext());//tmp.setnext sera igual a tmp.getnext().getnext()
							sentinel.setNext(sentinel.getNext().getNext()); //y sentinel en su setnext sera igual a sentinel.getnext().getnext()
						}else
						{
							tmp.setNext(tmp.getNext().getNext());//si no tmp.setnext sera igual a tmp.getnext().getnext();
						}
					}
				}
			}
		 ///////////////////////////////////////////////////////
		 public void replace(T value, T nuevo)
			{
				Search(value).setValue(nuevo);//buscamos el valor que vamos a remplazar y le asiganmos el valor nuevo con .setValue
			}
		 
		 
}