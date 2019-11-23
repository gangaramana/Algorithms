package recurrsion;

import java.io.File;


public class FileRecursion {
    int k=0;
    public static void main(String[] args) {
        FileRecursion fileRecursion = new FileRecursion();
        fileRecursion.lis(new File("C:\\workarea_ramana\\oldworkarea\\Notes\\Hadoop\\ML"),"");
    }


    public void lis(File str,String indent) {

        File[] li = str.listFiles();
        for (File file : li) {
            if (file.isDirectory()) {
                System.out.println(indent+file.getName());
                lis(file,indent+"  ");

            } else {
                k++;
                System.out.println(indent+file.getName());
            }
        }
    }
}
