import java.io.*;

/**
 * Created by siku on 5/9/17.
 */
public class CopyImage {
    File source_;
    File aim_;

    CopyImage() {
        super();
        source_ = new File("./1.jpg");
        aim_ = new File("./2.jpg");
    }

    void copy() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(this.source_));
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.aim_));
        byte [] b = new byte[1024];
        int i = 0;
        while ((i = dataInputStream.read(b)) == 1024){
            dataOutputStream.write(b);
        }
        dataOutputStream.write(b);
    }

}

class TestCopyImage{
    public static void main(String argv[]) throws IOException {
        CopyImage copyImage = new CopyImage();
        copyImage.copy();
    }
}