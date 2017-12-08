import javax.swing.*;

/**
 * Created by student on 12/4/17.
 */
public class Main extends JPanel {

    public static void main(String[] args) {
        final int target = 10000;
        int noImprovement = 0;
        double lastScore;

        Population p = new Population(20);
        while (noImprovement < target) {
            lastScore = p.chromosomes.get(0).getV();
            p.gen();

            if (lastScore >= p.chromosomes.get(0).getV()) {
                noImprovement++;
            } else noImprovement = 0;

            if (p.generation % 10 == 0){
                System.out.print("[");
                for(Chromosome c: p.chromosomes){
                    System.out.print(c.getV()+", ");
                }
                System.out.println();
            }

        }
        System.out.println("Population generation: " + p.generation);
        System.out.println("Total Distance: " + p.chromosomes.get(0).getV());
    }
}
