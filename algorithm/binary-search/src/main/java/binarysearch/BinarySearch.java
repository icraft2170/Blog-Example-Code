package binarysearch;

import java.util.List;

public class BinarySearch {

  public BinarySearch() {
  }

  public int binarySearch(int arr[], int target) {
    int searchCount = 0;
    int low = 0;
    int high = arr.length - 1;
    int mid;

    while(low <= high) {
      mid = (low + high) / 2;
      if (arr[mid] == target){
        searchCount++;
        return searchCount;
      }
      else if (arr[mid] > target) {
        high = mid - 1;
        searchCount++;
      }
      else {
        low = mid + 1;
        searchCount++;
      }
    }
    return -1;
  }

  public int basic(int arr[], int target) {
    int low = 0;
    int high = arr.length - 1;
    int mid;

    while(low <= high) {
      mid = (low + high) / 2;
      if (arr[mid] == target){
        return mid;
      }
      else if (arr[mid] > target) {
        high = mid - 1;
      }
      else {
        low = mid + 1;
      }
    }
    return -1;
  }
}
