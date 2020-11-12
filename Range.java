// Create a range package to export the Range class
package com.ZipCodeRange.challenge;

// Create a Range class for range object creation
public class Range {
 private int upperBound;
 private int lowerBound;

 // Constructor 
 // *parameters as lowerBound and upperBound values
 public Range(int lowerBound, int upperBound) {
  if (lowerBound <= upperBound) {
   // Use "this" keyword to refer to the current range object
   this.lowerBound = lowerBound;
   this.upperBound = upperBound;
  } else {
   this.lowerBound = upperBound;
   this.upperBound = lowerBound;
  }
 }

 // Generate Getter and Setter Method for the private fields "lowerBound" and "upperBound" of current range object.
 public int getLowerBound() {
  return this.lowerBound;
 }

 public int getUpperBound() {
  return this.upperBound;
 }

 public void setLowerBound(int lowerBound) {
  this.lowerBound = lowerBound;
 }

 public void setUpperBound(int upperBound) {
  this.upperBound = upperBound;
 }

 // Generate a format of String for the range.
 public String formatString() {
  return String.format("[%d,%d]", this.lowerBound, this.upperBound);
 }
}
