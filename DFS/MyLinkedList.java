class MyLinkedList
{
   //erstes Element in der Liste
   public MyListElement head;
   //letztes Element in der Liste
   public MyListElement tail;  
   //Anzahl der Elemente in der Liste
   public int numberOfElements;

   //Methode zum Einfuegen eines Elements am Ende der Liste
   public void addElementAtTail(String x)
   {
      //neues Listenelement anlegen
      MyListElement newListElement = new MyListElement();
      //die in diesem Listenelement zu speichernde Zahl ablegen
      newListElement.z = x;
      //die Verbindung zur bisherigen verketteten Liste herstellen
      if(numberOfElements == 0)
      {
         head = newListElement;
         tail = newListElement;
      }
      else
      {
         newListElement.prev = tail;
         tail.next = newListElement;
         tail = newListElement;
      }

      numberOfElements++;
   }
   public void addElementAtTailUndiscovered(String x, boolean discovered)
   {
      //neues Listenelement anlegen
      MyListElement newListElement = new MyListElement();
      //die in diesem Listenelement zu speichernde Zahl ablegen
      newListElement.z = x;
	  newListElement.discovered=discovered;
      //die Verbindung zur bisherigen verketteten Liste herstellen
      if(numberOfElements == 0)
      {
         head = newListElement;
         tail = newListElement;
      }
      else
      {
         newListElement.prev = tail;
         tail.next = newListElement;
         tail = newListElement;
      }

      numberOfElements++;
   }
	public void addNeighboursToNode(String nodeBuscar, String[] veinsAfegir){
		MyListElement node = head;
		for(int i=0; i<numberOfElements;i++){
			if(node.z.charAt(0) == nodeBuscar.charAt(0)){
				node.veins = new String[veinsAfegir.length];
				node.veins = veinsAfegir;
				return;
			}
			node=node.next;
		}
	}

   //Konstruktor der Klasse
   public MyLinkedList()
   {
      numberOfElements = 0;
   }

   //Methode zur Ausgabe aller Elemente in der Liste
   public void printAllElements()
   {
      //Ausgabe soll mit dem ersten Element starten
      MyListElement e = head;

      //Schleife zum Durchlaufen der Liste
      for(int i = 0; i < numberOfElements; i++)
      {
         //Ausgabe der im Element e abgelegten Zahl
         System.out.println(e.z);
         //gehe zum naechsten Element
         e = e.next;
      }
   }

   //Methode zum Einfuegen eines Elements am Beginn der Liste
   public void addElementAtHead(String x)
   {
      //neues Listenelement anlegen
      MyListElement newListElement = new MyListElement();
      //die in diesem Listenelement zu speichernde Zahl ablegen
      newListElement.z = x;
      //die Verbindung zur bisherigen verketteten Liste herstellen
      if(numberOfElements == 0)
      {
         head = newListElement;
         tail = newListElement;
      }
      else
      {
         newListElement.next = head;
         head.prev = newListElement;
         head = newListElement;
      }

      numberOfElements++;
   }

   //Methode zum Entfernen des letzten Elements in der Liste
   public String removeLastElement()
   {
      //Wir wollen uns die im zu entfernenden
      //Listenelement abgelegte Zahl merken.
      String x = "0";
      //Nur wenn die Liste mindestens ein Element enthaelt,
      //gibt es tatsaechlich etwas zu entfernen.
      if(numberOfElements > 0)
      {
         //abgelegte Zahl merken
         x = tail.z;
         //tail aktualisieren
         tail = tail.prev;
         //Anzahl der Elemente aktualisieren
         numberOfElements--;
         //Wenn noch Elemente uebrig sind, soll
         //das letzte keinen Nachfolger haben.
         if(numberOfElements > 0)
         {
            tail.next = null;
         }
      }
      
      return x;
   }

   //Methode zum Entfernen des ersten Elements in der Liste
   public String removeFirstElement()
   {
      //Wir wollen uns die im zu entfernenden
      //Listenelement abgelegte Zahl merken.
      String x = "0";
      //nur wenn die Liste mindestens ein Element enthaelt,
      //gibt es tatsaechlich etwas zu entfernen
      if(numberOfElements > 0)
      {
         x = head.z;
         //head aktualisieren
         head = head.next;
         //Anzahl der Elemente aktualisieren
         numberOfElements--;
         //Wenn noch Elemente uebrig sind, soll
         //das erste keinen Vorgaenger haben.
         if(numberOfElements > 0)
         {
            head.prev = null;
         }
      }
      
      return x;
   }
	public void einfuegenAnPosition(int pos, String x) {

		//Überprüfen ob die übergebene Position sinnvoll ist.
		if(pos==0){
			System.out.println("Bitte, Methode addElementAtHead benutzen.");
			return;
		}
		if(pos==numberOfElements){
			System.out.println("Bitte, Methode addElementAtTail benutzen.");
			return;
		}
		if(pos>numberOfElements){
			System.out.println("Die Liste hat nicht so viele Positionen.");
			return;
		}
		if(pos<0){
			System.out.println("Bitte eine positive Zahl angeben.");
			return;
		}
		
		MyListElement neuesListElement = new MyListElement(); //Neues Element, der eingefügt werden muss
		neuesListElement.z = x; //Wert des neues Element

		MyListElement e = head;
		for(int i=2; i<=pos ;i++){ //Gehe bis dem Element in der Liste, der in der Position pos-1 liegt. Es wird das vorherige des neues Elements sein.
			e = e.next;
		}
		
		neuesListElement.next=e.next;	//.next des neues Elements bestimmen
		neuesListElement.prev=e;		//neues Element muss vorheriges Element als prev haben
		e.next.prev=neuesListElement;	//naechstes Element muss neues Elements als prev haben. /* Correcció aportada a uebung 3 */
		e.next=neuesListElement;		//vorheriges Element muss das neues Element als next haben
		
		//Anzahl an Elementen aktualisieren.
		numberOfElements++;
	}
	public boolean undiscoveredNeighbourExists(String searchedNode){
		MyListElement unknownNode = head;
		boolean neighbourExists = false;
		for(int i=0;i<numberOfElements;i++){							//busco un element que sigui igual al node que vull examinar
			if(unknownNode.z.charAt(0)==searchedNode.charAt(0)){		//l'element es igual al node que vull examinar
				for(int a=0;a<unknownNode.veins.length;a++){			//examino els seus veins
					String researchedNeigbour = unknownNode.veins[a];
					MyListElement researchedNeigbourElement = head;
					for(int b=0;b<numberOfElements;b++){				//busco l'element igual al meu vei
						if(researchedNeigbourElement.z.charAt(0)==researchedNeigbour.charAt(0)){	//trobo l'element igual al vei
							if(researchedNeigbourElement.discovered==false){						//comprovo que no esta descobert
								neighbourExists = true;
								return neighbourExists;												//queda un vei no descobert
							}
						}
						researchedNeigbourElement=researchedNeigbourElement.next;			//busco el següent element a veure si es igual al vei
					}
				}
			}
			unknownNode=unknownNode.next;								//busco el següent element que sigui igual al node que vull examinar
	   }
		return neighbourExists;
	}
	public String selectUndiscoveredNeighbour(String node){
		MyListElement centralNode = head;								//Element que ha de coincidir amb el node que busco
		for(int i=0;i<numberOfElements;i++){							//Reviso tots els elements
			if(centralNode.z.charAt(0)==node.charAt(0)){				//Trobo l'element que és igual al node
			int nombreDeVeins = centralNode.veins.length;
				for(int a=0;a<nombreDeVeins;a++){						//Reviso els diversos veins
					String searchedNeighbour = centralNode.veins[a];	//Vei a buscar
					MyListElement searchingNeighbour = head;
					for(int b=0;b<numberOfElements;b++){
						if(searchedNeighbour.charAt(0)==searchingNeighbour.z.charAt(0)){	//He trobat el vei
							if(searchingNeighbour.discovered==false){						//El vei no ha estat descobert
								return searchingNeighbour.z;								//Vei a retornar
							}
						}
						searchingNeighbour=searchingNeighbour.next;
					}
				}
			}
			centralNode=centralNode.next;								//Següent element
		}
		return "ERROR";
   }
   //Mira si tots els elements han estat descoberts o no. Si queden elements per descobrir, false.
   public boolean discoveredList(){
	   boolean allElementsdiscovered=true;
	   MyListElement nodes = head;
	   for(int i=0;i<numberOfElements;i++){
		   if(nodes.discovered==false){
			   allElementsdiscovered=false;
			   return allElementsdiscovered;
		   }
		   nodes=nodes.next;
	   }
	   return allElementsdiscovered;
   }
   //Només usar després de saber que queden nodes per descobrir.
   public String selectUndiscoveredNode(){
	   String undiscoveredNode="Error";
	   MyListElement node=head;
	   for(int i=0;i<numberOfElements;i++){
		   if(node.discovered==false){
			   return node.z;
		   }
		   node=node.next;
	   }
	   return undiscoveredNode;
   }
   public void markDiscovered(String nodeBuscat){
	   MyListElement node=head;
	   for(int i=0;i<numberOfElements;i++){
		   if(node.z==nodeBuscat){
			   node.discovered=true;
			   return;
		   }
		   node=node.next;
	   }
   }
}
