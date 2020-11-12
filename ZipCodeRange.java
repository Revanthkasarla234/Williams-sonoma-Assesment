package com.ZipCodeRange.challenge;

//import range class
import com.ZipCodeRange.challenge.Range;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class ZipCodeRange {
 // Static variable in Main class for Range Object initialize at start from the
 // List interface; to store as array list of range objects.
 private static List<Range> rangeList = new ArrayList<Range>();

 // Static Method to generateMinimumRanges method to add or remove or modify
 // rangeList.
 public static void generateMinimumRanges(Range range) {
  // rangeList size check for comparison
  if (rangeList.size() == 0) {
 // if rangeList null then add the object to the List.
 rangeList.add(range);
  } else {

 // The rangeListIterator interface allows to iterate rangeList, modify the List
 // during iteration, and obtain the Iterator's current position in the List.
 ListIterator<Range> rangeListIterator = rangeList.listIterator();

 // should the new range be added into the rangeList? Default is true
 boolean addToRangeList = true;

 // Iterates through range objects in rangeList
 while (rangeListIterator.hasNext()) {

  // Gives the next range object from the List
  Range nextRange = rangeListIterator.next();

  /*
   * Possible conditions for the new range compared to existing rageList
   * 
   */

  // If the range of a new range object is within/inside the range of the current
  // rangeList object in the iteration.
  if (range.getLowerBound() >= nextRange.getLowerBound()
  && range.getUpperBound() <= nextRange.getUpperBound()) {
   // Don't add the new range object to the List.
   addToRangeList = false;

   // If the new range is larger than the range of the current rangeList object in
   // the iteration.
  } else if (range.getLowerBound() < nextRange.getLowerBound()
  && range.getUpperBound() > nextRange.getUpperBound()) {
   // Remove that range object from the List.
   rangeListIterator.remove();
   addToRangeList = true;

   // If the new range is outside the range of the current rangeList object in the
   // iteration.
  } else if (range.getLowerBound() > nextRange.getUpperBound()
  || range.getUpperBound() < nextRange.getLowerBound()) {
   // Add this new range object to the List.
   addToRangeList = true;

   // If the new range overlaps lowerBound of the current rangeList object in the
   // iteration.
  } else if (range.getLowerBound() < nextRange.getLowerBound()
  && range.getUpperBound() < nextRange.getUpperBound()) {
   // Set upperBound of the new range object to upperBound of the current rangeList
   // object in the iteration.
   range.setUpperBound(nextRange.getUpperBound());
   // remove the current rangeList object in the iteration to overlap with new
   // lowerBound of the range provided.
   rangeListIterator.remove();
   // add overlapped range to the rangeList
   addToRangeList = true;
   // If the new range overlaps upperBound of the next range object
  } else if (range.getLowerBound() > nextRange.getLowerBound()
  && range.getUpperBound() > nextRange.getUpperBound()) {
   // Set lowerBound of the new range object to lowerBound of the next range object
   range.setLowerBound(nextRange.getLowerBound());
   // remove the current rangeList object in the iteration to overlap with new
   // upperBound of the range provided.
   rangeListIterator.remove();
   // add overlapped range to the rangeList
   addToRangeList = true;
  }
 }

 // add the range to the rangeList.
 if (addToRangeList) {
  rangeList.add(range);
 }
  }
 }

 // Static Method to printRanges method that prints every range object in
 // rangeList
 public static void printRanges() {
  if (rangeList.size() > 0) {
 // Iterate through range objects in rangeList
 for (Range range : rangeList) {
  System.out.println(range.formatString());
 }
  }
 }

 public static void main(String[] args) {

  // Create new range objects from the Range class
  Range rangeOne = new Range(94133, 94133);
  Range rangeTwo = new Range(94200, 94299);
  Range rangeThree = new Range(94600, 94699);

  // Pass newly created range objects into the generateMinimumRanges method to add
  // or modify zipCodeRange
  ZipCodeRange.generateMinimumRanges(rangeOne);
  ZipCodeRange.generateMinimumRanges(rangeTwo);
  ZipCodeRange.generateMinimumRanges(rangeThree);

  // print the rages.
  ZipCodeRange.printRanges();
 }
}
