import java.util.Scanner;
class Tiefensuche{
	public static void tiefenSucheAlg(MyLinkedList vertexOriginals){
		MyLinkedList arestaSpannbaum = new MyLinkedList();
		MyStack vertexVisitats = new MyStack();
		String node;
		
		while(vertexOriginals.discoveredList()==false){
			node = vertexOriginals.selectUndiscoveredNode();						//Selecciono un node no-descobert.
			//System.out.println("He seleccionat el node: '"+node+"'");
			vertexOriginals.markDiscovered(node);									//El marco com a descobert.
			vertexVisitats.push(node);
			//System.out.println("Poso el node '"+node+"' al Stack.");				//El poso a l'Stack
			while(vertexOriginals.undiscoveredNeighbourExists(node)){				//mentre existeixi un vei d'aquest node
				String neighbour;
				neighbour = vertexOriginals.selectUndiscoveredNeighbour(node);		//selecciono el vei
				//System.out.println("He trobat el vei no-descobert '"+neighbour+"'");
				vertexOriginals.markDiscovered(neighbour);							//el marco com a descobert
				vertexVisitats.push(neighbour);										//el fico dins l'Stack
				String arestaAfegir = node+neighbour;
				//System.out.println("Afageixo l'aresta al Spannbaum: '"+arestaAfegir+"'");
				arestaSpannbaum.addElementAtTail(arestaAfegir);
				node=neighbour;														//aquest vei ara es el principal
				while(vertexOriginals.undiscoveredNeighbourExists(node)==false && vertexVisitats.isEmpty()==false){	//Si no queden més veins i l'Stack no està buit
					node=vertexVisitats.pop();
				}
			}
		}
		
		System.out.println("Existeix un Spannbaum amb les seguents arestes: ");
		arestaSpannbaum.printAllElements();
		return;
	}
	public static void main(String[] args){
		MyLinkedList vertexOriginals = new MyLinkedList(); //Llista de tots els vertexs, amb la caracterisitica de si està visitada = false des d'inici
		
		// Introduir els vertexs del Graf des del terminal.
		Scanner vertexsGraf = new Scanner(System.in);
		String vertexsGrafInLlista;
		System.out.println("Introdueix el nom dels vertexs del graf, separats per espais: ");
		vertexsGrafInLlista = vertexsGraf.nextLine();					//Afageixo una línia
		String[] vertexsGrafIn = vertexsGrafInLlista.split("\\s+");		//Reconeix que els espais serveixen per separar elements del String.
		
		//Comprovar que tots els vèrtexs tenen nom diferents i que només contenen un caràcter.
		for(int i=0;i<vertexsGrafIn.length;i++){
			if(vertexsGrafIn[i].length()!=1){
				System.out.println("ERROR -- El nom del vertexs ha de contenir nomes un caracter!");
				return;
			}
			for(int a=i+1;a<vertexsGrafIn.length;a++){
				if(vertexsGrafIn[i].charAt(0)==vertexsGrafIn[a].charAt(0)){
					System.out.println("ERROR -- No hi poden haver dos vertexs amb el mateix nom!");
					return;
				}
			}
		}
		//Afageixo els vertexs Introduits a la llista de vèrtexs.
		for(int i=0;i<vertexsGrafIn.length;i++) {
			vertexOriginals.addElementAtTailUndiscovered(vertexsGrafIn[i],false);
		}
		
		MyListElement nodeAfegirVeins = new MyListElement();
		nodeAfegirVeins = vertexOriginals.head;
		for(int i=0;i<vertexOriginals.numberOfElements;i++){
			System.out.println("Introdueix els veins de '"+nodeAfegirVeins.z+"': ");	//M'indica els veins de quin node afegir
			Scanner veinsNodeScann = new Scanner(System.in);
			String veinsNodeInLlista;
			veinsNodeInLlista = veinsNodeScann.nextLine();
			String[] veinsNodeIn = veinsNodeInLlista.split("\\s+");
			for(int a=0;a<veinsNodeIn.length;a++){										//Per cada vei introduït, confirmar que només té un caràcter i que no es repeteixen.
				if(veinsNodeIn[a].length()!=1){
					System.out.println("ERROR -- El nom dels veins ha de contenir nomes un caracter!");
					return;
				}
				for(int b=a+1;b<veinsNodeIn.length;b++){
					if(veinsNodeIn[a].charAt(0)==veinsNodeIn[b].charAt(0)){
						System.out.println("ERROR -- No hi poden haver dos veins amb el mateix nom!");
						return;
					}
				}
				if(veinsNodeIn[a].charAt(0)==nodeAfegirVeins.z.charAt(0)){
					System.out.println("ERROR -- Un node no pot ser vei d'ell mateix!");
					return;
				}
			}
			vertexOriginals.addNeighboursToNode(nodeAfegirVeins.z, veinsNodeIn);
			nodeAfegirVeins = nodeAfegirVeins.next;
		}		
		tiefenSucheAlg(vertexOriginals);
	}
}