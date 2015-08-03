package edu.wit.apppath;

import java.io.Serializable;

public class DirectionStep implements Serializable {

	 private String directionString;
	 private String building;
	 private int floor;

	  
	 public DirectionStep(String directionString, String building, int floor) {
	  super();
	  this.directionString = directionString;
	  this.building = building;
	  this.floor = floor;
	 }
	 
	 public String getDirection()
	 {
		 return directionString;
	 }
	 
	 public String getBuilding()
	 {
		 return building;
	 }
	 public int getFloor()
	 {
		 return floor;
	 }
	 
	 public void setDirection(String direction)
	 {
		 this.directionString = direction;
	 }
	 
	 public void setBuilding(String building)
	 {
		 this.building = building;
	 }
	
	 public void setFloor(int floor)
	 {
		 this.floor = floor;
	 }
}
