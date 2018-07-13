package Collection;

import java.util.*;

public class MapTest {

	public static void main(String[] args) {
		HashMap<Integer,String> map = new HashMap<>();
		map.put(10, "ten");
		map.put(20,"twenty");
		map.put(30,"thirty");
		//System.out.println(map.get(10));
		Set<Integer> ks = map.keySet();
		
		
		for(Integer k : ks)
		{
			System.out.println(map.get(k));
		}
		
		
	}

}
