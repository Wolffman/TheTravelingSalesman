import javax.swing.*;

/**
 * Created by student on 12/4/17.
 */
public class Main extends JPanel{
 static   Answer[] list= new Answer[20];
    public static void start(){
        TestCities test= new TestCities();
        for (int i = 0; i < list.length; i++) {
            list[i].create(test.getCities());
        }
    }

    public static void main(String[] args) {

    }
}
