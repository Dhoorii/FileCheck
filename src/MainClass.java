import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jacek on 2017-10-02.
 */
public class MainClass {
    static String filePath="data\\archive",fileNaveDate="20161212";
    static String[] clientName = {"ssc","gmbh"};
    public static void main(String[] args)
    {

        for (int i = 0 ; i < 2 ; i ++) {
            String element = clientName[i];
            String fileName = element + "_" + fileNaveDate;
            File f = findFile(filePath, fileName);
            if (f != null)
                System.out.printf("file exists");
        }
    }
    public static File findFile(String path, String fName) {
        File f = new File(path);
        if (f.getName().contains(fName))
            return f;
        if (f.isDirectory()) {
            for (String aChild : f.list()) {
                File ff = findFile(path + File.separator + aChild, fName);
                if (ff != null)
                    return ff;
            }
        }
        return null;
    }

}
