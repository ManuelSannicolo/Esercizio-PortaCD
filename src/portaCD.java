public class portaCD {
    private CD [] dischi;
    private int max_num_cd=10;

    public portaCD(){
        dischi=new CD [max_num_cd];
    }


    public portaCD(int n){
        max_num_cd=n;
        dischi= new CD [n];
    }

    public portaCD(portaCD p){
        this(p.dischi.length);
        for (int i = 0; i < dischi.length; i++) {
            if(p.dischi[i]!=null)
                this.dischi[i]= new CD(p.dischi[i]);
        }
    }

    public int setCD(CD c, int pos){
        int result=pos;
        if(pos>=0 && pos<max_num_cd){
            if(this.dischi[pos]==null)
                this.dischi[pos]=new CD(c);
            else
                result=-2;
        }else
            result=-1;

        return result;
    }


    public CD getCD(int pos){
        CD result;
        if(pos>=0 && pos<max_num_cd){
            if(this.dischi[pos]!=null)
                result=new CD(this.dischi[pos]);
            else
                result=null;
        }else
            result=null;

        return result;
    }


    public int killCD(int pos){
        int result=pos;
        if(pos>=0 && pos<max_num_cd){
            if(this.dischi[pos]!=null)
                this.dischi[pos]=null;
            else
                pos=-2;

        }else
            pos=-1;

        return result;
    }


    public int getNumMaxCD(){
        return this.max_num_cd;
    }

    public int getN(){
        int result=0;
        for (int i = 0; i < dischi.length; i++) {
            if(this.dischi[i]!=null)
                result++;
        }

        return result;
    }

    public String toString(){
        String s="";
        for (int i = 0; i < dischi.length; i++) {
            if(this.dischi[i]!=null)
                s+=String.format("%d. titolo: %s --- autore: %s \n", i, dischi[i].getTitolo(), dischi[i].getAutore());
            else    
                s+=i+". vuoto \n";
        }

        return s;
    }



    public int cercaCDPerTitolo(String titolo){
        int result=-1;
        int i=0;
        while(i<max_num_cd && result==-1){
            if(this.dischi[i]!=null){
                String corrente=this.dischi[i].getTitolo();
                if(titolo.equalsIgnoreCase(corrente))
                result=i;
            }
            i++;
        }


        return result;
    }
    public int confrontaCollezione(portaCD p){
        int result=0;
        for (int i = 0; i < dischi.length; i++) {
            if( this.dischi[i]!=null ){
                String corrente=this.dischi[i].getTitolo();
                if(p.cercaCDPerTitolo(corrente)!=-1)
                    result++;
            }
        }

        return result;
    }


    public boolean confrontaTotale(Object b){
        boolean verifica=false;
        if(this==b){
            verifica=true;
        }else{
            if(b instanceof portaCD){
                portaCD p = (portaCD)b;
                if(getN()==p.getN()){
                    int i=0;
                    int cont=0;
                    boolean diverso=false;
                    while( cont<getN() && !diverso && i<max_num_cd  ){
                        if(this.dischi[i]!=null){
                            String corrente=this.dischi[i].getTitolo();
                            int pos=p.cercaCDPerTitolo(corrente);
                            if(pos!=-1){
                                if(!(this.dischi[i].equals(p.getCD(pos))))
                                    diverso=true;
                                cont++;
                            }
                        }
                        i++;
                    }

                    if(!diverso)
                        verifica=true;
                }
            }
        }
        return verifica;
    }




}