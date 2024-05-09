public class App {
    public static void main(String[] args) throws Exception {
        

        //verifica costruttore CD
        CD c1= new CD("La noia", "Angelina Mango", 1, 3.3);
        CD c2= new CD("Tuta gold", "Mamhod", 1, 15.0);
        CD c3= new CD(c1);

        //verifica get classe CD
        System.out.println(c1);
        System.out.println("titolo: "+c1.getTitolo());
        System.out.println("autore: "+c1.getAutore());
        System.out.println("n brani: "+c1.getBrani());
        System.out.println("durata: "+c1.getDurata());

        //verifica set classe CD
        c1.setTitolo("Se ne va");
        c1.setAutore("3D");
        c1.setBrani(3);
        c1.setDurata(12.7);


        //verifica compareDurate (prima c2 è maggiore poi c1 è maggiore)
        System.out.println(c1.compareDurata(c2));
        c2.setDurata(3.3);
        System.out.println(c1.compareDurata(c2));


        //verifica costruttori classe portaCD
        portaCD p1 = new portaCD(10);
        p1.setCD(c1,0); //verifica set
        p1.setCD(c2, 3);
        p1.setCD(c3, 7);
        System.out.println(p1); //verifica toString

        CD recuperato= p1.getCD(0);
        System.out.println(recuperato);


        //veririca costruttore di default
        portaCD p2 = new portaCD(p1);
        p2.setCD(c1, 4);
        System.out.println(p1.getCD(4)); //restituisce null, deep copy
        System.out.println(p1.getCD(0)); //verifica getCD


        //veririca kill CD
        p2.killCD(4);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println("n CD presenti in p1: " +p1.getN()); 
        System.out.println("n CD presenti in p2: "+p2.getN());
        System.out.println("dimensione totale portaCD: " + p1.getNumMaxCD());

        //verifica metodo cerca cd (restituisce la posizione) e il get CD
        CD cercato = p2.getCD(p2.cercaCDPerTitolo("Tuta Gold"));
        System.out.println(cercato);


        //verifica metodo confronta numero di dischi in comune 
        p1.killCD(0);
        p1.setCD(c1, 5); //sposto il cd c1
        System.out.println("numero cd in comune: "+p1.confrontaCollezione(p2)); //3 cd in comune
        p2.killCD(0);
        System.out.println("numero cd in comune: "+p1.confrontaCollezione(p2)); //2 cd in comune

    }
}