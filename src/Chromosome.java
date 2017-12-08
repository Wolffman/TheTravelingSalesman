import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by student on 12/7/17.
 */
public class Chromosome {
    ArrayList<City> members = new ArrayList<>();
    int distanceTotal;
    TestCities testCities = new TestCities();

    final double mutationRate = 1;

    public Chromosome(){
        Collections.addAll(members, testCities.getCities()); //add all test cities to members
        Collections.shuffle(members);
    }

    public Chromosome(ArrayList<City> cities){
        members = cities;
        mutate();
    }

    public int getV(){
        distanceTotal = 0;
        for (int i = 0; i < members.size()-1; i++) {
            distanceTotal += members.get(i).distanceTo(members.get(i+1));
        }
        return distanceTotal;
    }


    public void mutate(){
        if(Math.random()<mutationRate) {
            for (int i = 0; i < 2; i++) {
                int one = (int) (Math.random() * members.size());
                int two = (int) (Math.random() * members.size());
                City temp = members.get(one);
                members.set(one, members.get(two));
                members.set(two, temp);
            }
        }
        getV();
    }

    public Chromosome[] mateWith(Chromosome other) {
        ArrayList<City> c1 = new ArrayList<>();
        ArrayList<City> c2 = new ArrayList<>();

        int pivot = (int) (Math.random() * (members.size() - 1));
        for (int i = 0; i < members.size(); i++) {
            if (i < pivot) {
                c1.add(members.get(i));
                c2.add(other.members.get(i));
            } else {
                c1.add(other.members.get(i));
                c2.add(members.get(i));
            }
        }
        return new Chromosome[]{new Chromosome(c1), new Chromosome(c2)};
    }

}
