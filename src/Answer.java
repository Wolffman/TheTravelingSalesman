/**  * Created by student on 12/4/17.  */
public class Answer{
    City[] cits= new City[20];

    public Answer(City[] cits) {
        this.cits = cits;
    }

    public Answer() {
    }

    public City[] getCits() {
        return cits;
    }
    public void create(City[] masterList){
        City[]copy= masterList;
        for (int i = 0; i < cits.length; i++) {
            int ran= (int)(Math.random()*copy.length);
            if(copy[ran]!=null) {
                cits[i]= copy[ran];
                copy[ran]=null;
            }
            else {
                i--;
            }
        }
    }
}
