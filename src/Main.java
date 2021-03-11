import java.util.HashMap;
import java.util.Vector;

import static java.lang.System.exit;

public class Main {
    public static Vector<Integer> vec = new Vector<Integer>();
    public static Vector<Integer> vec2 = new Vector<Integer>();
    public static int number = 0, z;

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        String data = readFile.Read(args[0]);
        Rezolve rezolve = new Rezolve();
        Integer[] command = new Integer[4];
        Integer[][] execute = new Integer[1000][4];
        HashMap<Character, Integer> coding = new HashMap<Character, Integer>();
        int k = 0, j = 0, nrdeschise = 0, nrinchise = 0, poz=-1;
        for (int i = 0; i < data.length(); i++) {
            if (!coding.containsKey(data.charAt(i))) {
                coding.put(data.charAt(i), k);
                k++;
            }
            command[j] = coding.get(data.charAt(i));
            j++;
            if (j == 4) {
                int comanda = (command[0] + 5) * 1000 + (command[1] + 5) * 100 + (command[2] + 5) * 10 + command[3] + 5;
                if (comanda == 5678) {
                    nrinchise++;
                }
                if (comanda == 5665) {
                    nrdeschise++;
                }
                if (nrinchise > nrdeschise) {
                    poz = number;
                }
                vec.add(comanda);
                number++;
                k = 0;
                j = 0;
                coding.clear();
            }
        }
        if (k != 0) {
            System.err.print("Error:" + number);
            exit(-1);
        }
        if (nrinchise > nrdeschise) {
            System.err.print("Error:" + (poz-2));
            exit(-1);
        }
        if (nrdeschise != nrinchise) {
            System.err.print("Error:" + number);
            exit(-1);
        }

        for (int i = 0; i < number; i++) {
            int ok = rezolve.rezolve(vec.get(i));
            if (ok == 0) {
                System.err.print("Exception:" + i);
                exit(-2);
            }
            if (ok == 2) {
                z = i;
                i++;
                while (vec.get(i) != 5678) {
                    vec2.add(vec.get(i));
                    i++;
                }
                while (!rezolve.getfirst()) {
                    ok = rezolve.rezolve(vec.get(z));
                    if (ok == 0) {
                        System.err.print("Exception:" + (z));
                        exit(-2);
                    }
                    for (int h = 0; h < vec2.size(); h++) {
                        ok = rezolve.rezolve(vec2.get(h));
                        if (ok == 0) {
                            System.err.print("Exception:" + (z + h + 1));
                            exit(-2);
                        }

                    }
                }
            }

        }
        exit(0);
    }
}

