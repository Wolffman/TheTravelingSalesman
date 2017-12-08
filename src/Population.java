import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by student on 12/7/17.
 */
public class Population {
    final double elitism = 0.2;
    int size;
    ArrayList<Chromosome> chromosomes = new ArrayList<>();
    int generation;


    public Population(int size) {
        this.size = size;
        fill();
    }

    public void fill() {
        while (chromosomes.size() < size) {
            if (chromosomes.size() < size / 3) {
                chromosomes.add(new Chromosome());
            } else {
                mate();
            }
        }
    }

    public void sort() {
        chromosomes.sort(new Comparator<Chromosome>() {
            @Override
            public int compare(Chromosome o1, Chromosome o2) {
                return o1.getV() - o2.getV();
            }
        });
    }

    public void kill() {
        int target = (int) (elitism * chromosomes.size());

        while (chromosomes.size() > target) {
            chromosomes.remove(chromosomes.size() - 1);
        }
    }

    public void mate() {
        Chromosome key1 = chromosomes.get((int)(Math.random()*(chromosomes.size()-1)));
        Chromosome key2 = key1;

        while(key2 == key1){
            key2 = chromosomes.get((int)(Math.random()*(chromosomes.size()-1)));
        }

        Chromosome[] children = key1.mateWith(key2);
        chromosomes.add(children[0]);
        chromosomes.add(children[1]);
    }

    public void mutate(){
        for (int i = 1; i < chromosomes.size(); i++) {
            chromosomes.get(i).mutate();
        }
    }

    public void gen() {
        sort();
        kill();
        mate();
        fill();
        mutate();
        sort();
        generation++;
    }
}
