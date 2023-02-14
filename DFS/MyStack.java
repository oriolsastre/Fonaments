class MyStack
{
   //Stack soll auf Basis einer verketteten Liste
   //implementiert werden
   private MyLinkedList list;

   //Operation makeStack()
   public MyStack()
   {
      list = new MyLinkedList();
   }

   public boolean isEmpty()
   {
      if(list.numberOfElements > 0) {return false;}
      else {return true;}
   }

   public void push(String x)
   {
      list.addElementAtHead(x);
   }

   public String pop()
   {
      return list.removeFirstElement();
   }
   
   //Aufgabe 4.3------------------------
   public String[] MultiPop(int n){
	   //Array der entfernte Elemente aufruffen.
	   String[] removedElements;
	   //Falls n groesser als die Anzahl an Elemente der Liste ist
	   if(list.numberOfElements<n){
		   //Die Anzahl an Elemente die entfernt werden muessen, ist die Anzahl an Elemente der Liste
		   n=list.numberOfElements;
		   //Der Array muss so viele Elemente enthalten wie der Liste.
		   removedElements = new String[n];
		   //Alle Elementen sollen entfernt werden
		   for(int i=0;i<n;i++){
			   removedElements[i] = list.removeFirstElement();
		   }
	   } else {
		   //Der Array muss n Elemente enthalten.
		   removedElements = new String[n];
		   //Die ersten n Elemente sollen enfernt werden.
		   for(int i=0;i<n;i++){
			   removedElements[i] = list.removeFirstElement();
		   }
	   }
	   return removedElements;
   }
}
