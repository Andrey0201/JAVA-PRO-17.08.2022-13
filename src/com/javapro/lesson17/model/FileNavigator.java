package com.javapro.lesson17.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FileNavigator {

  public Map<String, List<FileData>> listMap = new HashMap<>();

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

  public List<FileData> find(String pathToFile) {
    return listMap.get(pathToFile);
  }

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

  public void remove(String pathToFile) {
    listMap.remove(pathToFile, listMap.get(pathToFile));
  }

  public List<FileData> sortBySize() {
    List<FileData> listSortBySize = getFileDataList();
    return listSortBySize.stream()
        .sorted(Comparator.comparing(FileData::getSize))
        .toList();
  }

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