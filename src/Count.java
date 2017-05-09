import java.io.*;

/**
 * Created by siku on 5/9/17.
 */
public class Count {
    File source_;
    File aim_;

    Count(){
        super();
        source_ = new File("./Early-Precaution.txt");
        aim_ = new File("./result.txt");
    }

    void count() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(this.source_));
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.aim_));

        int upper = 0;
        int lowwer = 0;

        char chara;
        while (dataInputStream.available() > 0){
            chara = (char)dataInputStream.readByte();
            System.out.print(chara+" ");
            if (Character.isLowerCase(chara)){
                lowwer++;
            }else if (Character.isUpperCase(chara)){
                upper++;
            }
            dataOutputStream.writeChar(Character.toUpperCase(chara));
        }

        System.out.println("大写："+upper);
        System.out.println("小写："+lowwer);
    }
}

class TestCount{
    public static void main(String argv[]) throws IOException {
        Count count = new Count();
        count.count();
    }
}