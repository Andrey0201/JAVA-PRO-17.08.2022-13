package com.javapro.lesson17;

import com.javapro.lesson17.model.FileData;
import com.javapro.lesson17.model.FileNavigator;

public class Main {

  public static void main(String[] args) {
    FileNavigator fileNavigator = new FileNavigator();
    fileNavigator.add("./file/",new FileData("file.txt",700,"./file/"));
    fileNavigator.add("./file/",new FileData("log.txt",500,"./file/"));
    fileNavigator.add("./file/",new FileData("config.txt",300,"./file/"));
    fileNavigator.add("./file/file1/",new FileData("myFile.txt",500,"./file/"));
    fileNavigator.add("./file/",new FileData("logistic.txt",200,"./file/"));
    fileNavigator.add("./file/newFile/",new FileData("logistic.txt",450,"./file/newFile/"));

    System.out.println(fileNavigator.sortBySize());

    System.out.println(fileNavigator);
    System.out.println(fileNavigator.find("./file/"));
   System.out.println(fileNavigator.sortBySize());
    System.out.println(fileNavigator.filterBySize(500));
    fileNavigator.remove("./file/");
   System.out.println(fileNavigator);
  }
}