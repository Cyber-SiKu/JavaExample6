import java.io.*;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Vector;

/**
 * Created by siku on 5/9/17.
 */
public class Sort {
    Random rand_;
    File file_;
    final int MAX = 10;
    Vector<Integer> integers_;
    Sort(){
        super();
        this.rand_ = new Random();
        this.file_ = new File("./data.txt");
        this.integers_ = new Vector<Integer>();
    }

    /*
    * create MAX numbers
    * */
    void createIntegers(){
        for (int i = 0;i < this.MAX;++i){
            Integer temp = this.rand_.nextInt();
            this.integers_.add(temp);
        }
    }

    void outPrint(){
        System.out.println();
        for (Integer i : integers_){
            System.out.print(i+" ");
        }
    }

    boolean saveIntegers(){
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.file_))) {
            for (Integer i : integers_){
                dataOutputStream.writeInt(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    boolean readIntegers() throws FileNotFoundException {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(this.file_)) {
        }) {
            System.out.println();
            int [] inter= new int[MAX];
            for (int i = 0;i < this.MAX;++i){
                inter[i] = dataInputStream.readInt();
                System.out.print(inter[i]+" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    void sort(){
        Collections.sort(this.integers_);
    }

    public int compare(Integer integer1,Integer integer2){
        return integer1 - integer2;
    }
}

class TestSort{
    public static void main(String argvs[]) throws FileNotFoundException {
        Sort sort = new Sort();
        sort.createIntegers();
        sort.outPrint();
        sort.saveIntegers();
        sort.sort();
        sort.outPrint();
        sort.saveIntegers();
    }
}