package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import data.Tuple;

public class MinimumPlatform {
	
	public static boolean isOverlap(Integer minX, Integer maxX, Integer minY, Integer maxY){
		
		return !(minY > maxX || maxY < minX );
				
	}
	
	public static boolean platformHasOverlap(List<Tuple<Integer,Integer>> platform, Tuple<Integer,Integer> train ){
		
		for(Tuple<Integer,Integer> times : platform){
			if(isOverlap(times.x, times.y, train.x,train.y)){
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean stationHasOpenPlatfom(Set<List<Tuple<Integer,Integer>>> station, 
			Tuple<Integer,Integer> train){
		for(List<Tuple<Integer,Integer>> platform : station){
			if(!platformHasOverlap(platform, train)){
				platform.add(train);
				return true;
			}
		}
		return false;
	}
	
	
	public static Integer findMinPlatforms(Integer[] arrivals, Integer[] departures){
		
		Set<List<Tuple<Integer,Integer>>> station = new HashSet<List<Tuple<Integer,Integer>>>();
		List<Tuple<Integer,Integer>> aPlatform = new ArrayList<Tuple<Integer,Integer>>();
		aPlatform.add(new Tuple<Integer,Integer>(arrivals[0], departures[0]));
		station.add(aPlatform);
				
		for(int i = 1; i < arrivals.length; i++){
			Tuple<Integer,Integer> train = new Tuple<Integer,Integer>(arrivals[i], departures[i]);
			if(!stationHasOpenPlatfom(station, train)){
				List<Tuple<Integer,Integer>> newPlatform = new ArrayList<Tuple<Integer,Integer>>();
				newPlatform.add(train);
				station.add(newPlatform);
			}
			
		}
		
		return station.size();
	}
	
	public static void main(String[] args){
		
		Integer[] arrivals = {900,  940, 950,  1100, 1500, 1800};
		Integer[] departures = {910, 1200, 1120, 1130, 1900, 2000};
		
//		System.out.println(isOverlap(900,910, 940, 950));
//		System.out.println(isOverlap(900,910, 905, 950));
//		System.out.println(isOverlap(900,910, 800, 900));
//		System.out.println(isOverlap(900,910, 800, 850));		
		
		System.out.println(findMinPlatforms(arrivals, departures));

	}

}
