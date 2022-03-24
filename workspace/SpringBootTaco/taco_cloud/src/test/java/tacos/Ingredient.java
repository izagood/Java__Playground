package tacos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredient {
	
	private final String id;
	private final String name;
	private final Type type;
	
	public static enum Type {
		WRAP("001", "랩"), PROTEIN("002"), VEGGIES("002"), CHEESE("002"), SAUCE("002"),;
		
		
	}

}
