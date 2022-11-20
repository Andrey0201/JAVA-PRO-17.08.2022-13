package com.javapro.lesson17.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Andrii Andriutsa
 */
public class FileNavigator {

  public Map<String, List<FileData>> listMap = new HashMap<>();

  /**
   * This method adds a file to the specified path. If the path already exists, then the new file is
   * added to the list already associated with the corresponding path. The path is a unique value
   * and is not repeated.
   * And it does not allow adding value when trying to add a FileData value
   * whose path value does not match the key path leading to the list of files.
   */
  public void add(String pathToFile, FileData data) {
    if (data.getPathToFile() == null) {
      System.out.println("PathToFile can't be null");
    } else if (!data.getPathToFile().equals(pathToFile)) {
      System.out.println("PathToKey and PathToFile different!!!");
      System.out.printf("PathToKey %s \n FileDate: {name: %s, size: %s, pathToFile:%s}\n",
          pathToFile, data.getNameFile(), data.getSize(), data.getPathToFile());
    } else {
      listMap.putIfAbsent(pathToFile, new ArrayList<>());
      listMap.get(data.getPathToFile()).add(data);
    }
  }

  /**
   * The method returns a list of files associated with the path passed as a parameter.
   */
  public List<FileData> find(String pathToFile) {
    return listMap.get(pathToFile);
  }

  /**
   * The method returns a list of files whose size (in bytes) does not exceed the value passed as a
   * parameter.
   */
  public List<FileData> filterBySize(int maxSize) {
    List<FileData> listData = getFileDataList();
    List<FileData> newSize = new ArrayList<>();
    for (FileData data : listData) {
      if (data.getSize() <= maxSize) {
        newSize.add(data);
      }
    }
    return newSize;

  }

  /**
   * The method removes the path and its associated files based on the path value passed as a
   * parameter.
   */
  public void remove(String pathToFile) {
    listMap.remove(pathToFile, listMap.get(pathToFile));
  }

  /**
   * The method sorts all available files by their size (in ascending order), then returns a list of
   * the sorted files.
   */
  public List<FileData> sortBySize() {
    List<FileData> listSortBySize = getFileDataList();
    return listSortBySize.stream()
        .sorted(Comparator.comparing(FileData::getSize))
        .toList();
  }
  /**
   *The method returns a list of added files.
   */
  private List<FileData> getFileDataList() {
    List<FileData> listData = new ArrayList<>();
    for (List<FileData> value : listMap.values()) {
      listData.addAll(value);
    }
    return listData;
  }

  @Override
  public String toString() {
    return "FileNavigator{" +
        "listMap=" + listMap +
        '}';
  }
}