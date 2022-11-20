package com.javapro.lesson17.model;


/**
 * @author Andrii Andriutsa
 * The class represents a specific file and consists of: file name, size in bytes, file path.
 */

public class FileData {

  private final String nameFile;
  private final int sizeFile;
  private final String pathToFile;


  public FileData(String nameFile, int sizeFile, String pathToFile) {
    this.nameFile = nameFile;
    this.sizeFile = sizeFile;
    this.pathToFile = pathToFile;
  }

  public String getNameFile() {
    return nameFile;
  }

  public int getSize() {
    return sizeFile;
  }

  public String getPathToFile() {
    return pathToFile;
  }

  @Override
  public String toString() {
    return "FileData{" +
        "nameFile='" + nameFile + '\'' +
        ", sizeFile=" + sizeFile +
        ", pathToFile='" + pathToFile + '\'' +
        '}' + "\n";
  }
}

