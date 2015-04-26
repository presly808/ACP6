package ua.artcode.week2.day2.io;

import java.io.*;

public class IOUtils {


    public static String readFromFileInputStream(String path)
            throws FileNotFoundException {
        StringBuilder res = new StringBuilder();
        InputStream is = new FileInputStream(path);
        try {
            int b = 0;
            while ((b = is.read()) != -1) {
                char c = (char) b;
                res.append(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res.toString();
    }

    public static void writeToFile(String path, String content) throws IOException {
        Writer writer = null;
        try {
            writer = new FileWriter(path);
            writer.write(content);
            writer.flush();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    public static void decorTest() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("");
        BufferedInputStream bis = new BufferedInputStream(fis);
        DataInputStream dis = new DataInputStream(bis);
        //dis.readUTF();
    }

    public static String find(File point, String key){

        if(point.isFile()){
            return point.getName().contains(key) ? point.getAbsolutePath() + "\n" : "";
        } else {
            String res = "";
            File[] children = point.listFiles();
            for(File f : children){
                res += find(f,key);
            }
            return res;
        }

    }

    public static void main(String[] args) {
        System.out.println(find(new File("/home/serhii/dev"),"iml"));
    }

}
