package org.amazon.solution2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution2 {

 public static void main(String[] args) {
  // Test = Seattle:60,Spokane:21,Olympia:5
  List<City> list = new ArrayList<City>();
  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  try {
	String line = bf.readLine();
	String[] cities = line.split(",");
	for(String city : cities){
		City c = new City();
		c.name = city.split(":")[0];
		c.population = Integer.parseInt(city.split(":")[1]);
		list.add(c);
	}
} catch (IOException e) {
	e.printStackTrace();
}
  
  
  for (int i = 0; i < 100; i++) {
   System.out.println(ramdomCity(list));
   
  }
 }
 
 
 public static String ramdomCity(List<City> list){
  List<String> listnames = new ArrayList<String>();
  for (City city : list) {
   for (int i = 0; i < city.population; i++) {
    listnames.add(city.name);
   }
  }
  Random ran = new Random();
  return listnames.get(ran.nextInt(listnames.size()));
 }
 

}

class City {
 String name;
 int population;
}