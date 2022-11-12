package integerparser.input;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FromFile implements InputParser{

    private Scanner scanner;
    private String pathName;

    public FromFile(String pathName) {
        this.pathName = pathName;
        reloadScanner();
    }

    @Override
    public Frame next() {
        if (!scanner.hasNext()){
            reloadScanner();
        }
        return parseNext();
    }

    private Frame parseNext() {
        var list = Arrays.asList(
            scanner.nextLine().split(",")
        );
        var integerList = list.stream()
            .map(x -> Integer.parseInt(x))
            .collect(Collectors.toList());

        var expeted = new LinkedList<Double>();
        for (int i = 0; i < 10; i++) {
                expeted.add(0.0);
        }
        expeted.set(integerList.remove(0), 1.0);
        var in = integerList.stream().map(x -> x/256.0).collect(Collectors.toList());

        return new Frame(in, expeted);

     
        
        
    }

    private void reloadScanner() {
        try {
            scanner = new Scanner(new File(pathName));
            scanner.nextLine();//Removing header
        } catch (Exception e) {
            System.out.println("Could not load file " + e);
        }
    }

    
    
}
