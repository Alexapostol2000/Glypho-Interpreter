import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Rezolve {
    private Vector<BigInteger> vec = new Vector<BigInteger>();
    private Scanner myObj = new Scanner(System.in);

    public boolean getfirst(){
        if(vec.size() == 0){
            return false;
        }
        if( vec.get(vec.size()-1).equals(BigInteger.valueOf(0)))
            return true;
        return false;
    }

    public int rezolve(int comanda) {
        BigInteger x;
        switch (comanda) {
            case 5567:
                vec.add(vec.size(), BigInteger.ONE);
                return 1;
            case 5666:
                if (vec.size() == 0) {
                    return 0;
                }
                System.out.println(vec.get(vec.size() - 1));
                vec.remove(vec.size() - 1);
                return 1;
            case 5555:
                return 1;
            case 5556:
                String x1 = myObj.next();
                try {
                    BigInteger y = new BigInteger(x1);
                    vec.add(vec.size(), y);
                } catch (Exception e) {

                    return 0;
                }
                return 1;
            case 5565:
                if (vec.size() == 0) {
                    return 0;
                }
                x = vec.get(vec.size() - 1);
                vec.remove(vec.size() - 1);
                vec.add(0, x);
                return 1;
            case 5656:
                if (vec.size() == 0) {
                    return 0;
                }
                vec.add(vec.size(), vec.get(vec.size() - 1));
                return 1;
            case 5657:
                if (vec.size() < 2) {
                    return 0;
                }
                BigInteger sum;
                sum = vec.get(vec.size() - 1).add(vec.get(vec.size() - 2));
                vec.remove(vec.size() - 1);
                vec.remove(vec.size() - 1);
                vec.add(vec.size(), sum);
                return 1;
            case 5677:
                if (vec.size() == 0) {
                    return 0;
                }
                vec.remove(vec.size() - 1);
                return 1;
            case 5566:
                if (vec.size() < 2) {
                    return 0;
                }
                x = vec.get(vec.size() - 1);
                vec.remove(vec.size() - 1);
                BigInteger y = vec.get(vec.size() - 1);
                vec.remove(vec.size() - 1);
                vec.add(vec.size(), x);
                vec.add(vec.size(), y);
                return 1;
            case 5655:
                if (vec.size() == 0) {
                    return 0;
                }
                x = vec.get(0);
                vec.remove(0);
                vec.add(vec.size(), x);
                return 1;
            case 5667:
                if (vec.size() < 2) {
                    return 0;
                }
                BigInteger prod;
                prod = vec.get(vec.size() - 1).multiply(vec.get(vec.size() - 2));
                vec.remove(vec.size() - 1);
                vec.remove(vec.size() - 1);
                vec.add(vec.size(), prod);
                return 1;
            case 5676:
                if (vec.size() == 0) {
                    return 0;
                }
                x = vec.get(vec.size() - 1).multiply(BigInteger.valueOf(-1));
                vec.remove(vec.size() - 1);
                vec.add(vec.size(), x);
                return 1;
            case 5665:
                if (vec.size() == 0) {
                    return 0;
                }
                return 2;
            case 5678:
                if (vec.size() == 0) {
                    return 0;
                }
                return 3;
            case 5675:
                if (vec.size() < 4  ) {
                    return 0;
                }
                int com;
                char c[] = new char[4];
                x = vec.get(vec.size() - 1);
                c[0] = (char) x.intValue();
                vec.remove(vec.size() - 1);
                x = vec.get(vec.size() - 1);
                c[1] = (char) x.intValue();
                vec.remove(vec.size() - 1);
                x = vec.get(vec.size() - 1);
                c[2] = (char) x.intValue();
                vec.remove(vec.size() - 1);
                x = vec.get(vec.size() - 1);
                c[3] = (char) x.intValue();
                vec.remove(vec.size() - 1);
                HashMap<Character, Integer> coding = new HashMap<Character, Integer>();
                Integer[] cmd = new Integer[4];
                int k = 0, j = 0;
                for (int i = 0; i < c.length; i++) {
                    if (!coding.containsKey(c[i])) {
                        coding.put(c[i], k);
                        k++;
                    }
                    cmd[j] = coding.get(c[i]);
                    j++;
                    if (j == 4) {
                        k = 0;
                        j = 0;
                        coding.clear();
                        int coma = (cmd[0] + 5) * 1000 + (cmd[1] + 5) * 100 + (cmd[2] + 5) * 10 + cmd[3] + 5;
                        return rezolve(coma);
                    }
                }
            default:
                return 0;
        }
    }
}

