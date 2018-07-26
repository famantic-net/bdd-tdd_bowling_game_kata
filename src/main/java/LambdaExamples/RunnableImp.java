package LambdaExamples;


import java.util.ArrayList;
import java.util.List;

public class RunnableImp {

    public List<Runnable> handles() {
        Runnable r1, r2;
        List<Runnable> list = new ArrayList<>();

        System.out.println("=== RunnableImp ===");

        // Anonymous Runnable
        r1 = new Runnable(){

            @Override
            public void run(){
                System.out.println("Hello world one!");
            }
        };
        list.add(r1);

        // Lambda Runnable
        r2 = () -> System.out.println("Hello world two!");
        list.add(r2);

        list.add(() -> System.out.println("Hello world three!"));

        // Run em!
        //r1.run();
        //r2.run();

         return list;

    }

}
