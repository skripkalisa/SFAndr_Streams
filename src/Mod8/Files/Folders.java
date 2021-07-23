package Mod8.Files;

import java.io.File;

public class Folders {
    public static void main(String[] args) {
        File folder = new File("src"); //Ваша папка
        System.out.println(folder.isDirectory());
        System.out.println(folder.getAbsolutePath());
        long size = getFolderSize(folder);
        System.out.println((size / 1024 ) + " KB");
    }

    private static long getFolderSize(File folder) {
        File[] files = folder.listFiles();
        long length = 0;
        int count = files.length;
        for (int i = 0; i < count; i++) {
            if (files[i].isFile()) {
                length += files[i].length();
            } else {
                length += getFolderSize(files[i]);
            }
        }
        return length;
    }
}
