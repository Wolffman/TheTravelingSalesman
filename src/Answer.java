import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *   * Created by student on 12/4/17.
 */
public class Answer {
    City[] cits = new City[20];
    TestCities test = new TestCities();
    City[] masterList = test.getCities();

    public Answer(City[] cits) {
        this.cits = cits;
    }

    public Answer() {
    }

    public City[] getCits() {
        return cits;
    }

    public void create(City[] masterList) {
        List<City> copy = new ArrayList<City>();
        for (int i = 0; i < masterList.length; i++) {
            copy.add(masterList[i]);
        }
        Answer x = new Answer();
        for (int i = 0; i < masterList.length; i++) {
            int rand = (int) (Math.random() * copy.size());
            x.getCits()[i] = copy.get(rand);
            copy.remove(rand);
        }
        this.setCits(x.getCits());
    }

    public void setCits(City[] cits) {
        this.cits = cits;
    }

    public int getV() {
        int sum = 0;
        for (int i = 0; i < cits.length - 1; i++) {
            sum += cits[i].distanceTo(cits[i + 1]);
        }
        return sum;
    }

    public Answer[] mate(Answer other) {
        int pivot = cits.length / 2;
        Answer childr1 = new Answer();
        Answer childr2 = new Answer();


        for (int i = 0; i < cits.length; i++) {
            if (i < pivot) {
                childr1.getCits()[i] = cits[i];
                childr2.getCits()[i + pivot] = other.getCits()[i];
            } else {
                childr2.getCits()[i - pivot] = cits[i];
                childr1.getCits()[i] = other.getCits()[i];
            }


        }
        Answer[] offspring = new Answer[2];
        childr1.clean();
        childr2.clean();
        offspring[0] = childr1;
        offspring[0] = childr2;
        return offspring;
    }

    public void clean() {
        List<City> dup = new ArrayList<>();
        List<City> missing = new ArrayList<>();
        List<City> copy = new ArrayList<>();
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < cits.length; i++) {
            copy.add(cits[i]);
        }
        for (int i = 0; i < copy.size(); i++) {
            if (copy.contains(copy.get(i)) && !dup.contains(copy.get(i))) {
                dup.add(copy.get(i));
                indexs.add(i);

            }
            if (!copy.contains(masterList[i])) {
                missing.add(masterList[i]);
            }
        }
        for (int i = 0; i < dup.size(); i++) {
            copy.set(indexs.get(i), missing.get(i));
        }
        indexs.clear();
        missing.clear();
        dup.clear();
        for (int i = 0; i < copy.size(); i++) {
            cits[i] = copy.get(i);
        }
        copy.clear();
    }

    public void mutate() {
        for (int i = 0; i < 2; i++) {
            int one = (int) (Math.random() * cits.length);
            int two = (int) (Math.random() * cits.length);
            City temp = cits[one];
            cits[one] = cits[two];
            cits[two] = temp;
        }


    }

    public void sort(){


    }

}
