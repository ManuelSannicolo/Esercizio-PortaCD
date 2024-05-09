public class CD {
    private String titolo="Unknown";
    private String autore="Unknown";
    private int brani=0;
    private double durata=0.0;
    

    public CD(String titolo, String autore, int brani, double durata){
        setTitolo(titolo);
        setAutore(autore);
        setBrani(brani);
        setDurata(durata);
    }


    public CD(){}

    public CD(CD c){
        this(c.titolo, c.autore, c.brani, c.durata); //sfrutto il costruttore master
    }


    public String getTitolo(){
        return this.titolo;
    }

    public void setTitolo(String titolo){
        this.titolo=titolo;
    }

    public String getAutore(){
        return this.autore;
    }

    public void setAutore(String autore){
        this.autore=autore;
    }

    public int getBrani(){
        return this.brani;
    }

    public void setBrani(int brani){
        this.brani=brani;
    }

    public double getDurata(){
        return this.durata;
    }

    public void setDurata(double durata){
        this.durata=durata;
    }


    public String toString(){
        String s="";
        s+=String.format("il cd si chiama %s; \n", this.titolo);
        s+=String.format("l'autore è %s; \n", this.autore);
        s+=String.format("il cd dura %.2f minuti; \n", this.durata);
        s+=String.format("il cd ha %d brani; \n", this.brani);
        return s;
    }


    public int compareDurata(CD c){
        int verifica=0;
        if(this.durata>c.getDurata())
            verifica=1;
        else if(this.durata<c.getDurata())
            verifica=-1;
        
        return verifica;
    }


    public boolean equals(Object b){
        boolean verifica=false;
        if(this==b){
            verifica=true;
        }else{
            if(b instanceof CD){
                CD c = (CD)b;
                if(this.titolo.equals(c.titolo) && this.autore.equals(c.autore)){
                    if(this.brani==c.brani && this.durata==c.durata){
                        verifica=true;
                    }
                    
                }
            }
        }
        return verifica;
    }



}