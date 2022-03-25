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
		
		WRAP("001", "랩"), 
		PROTEIN("002", "프로틴"), 
		VEGGIES("003", "채소"), 
		CHEESE("004", "치즈"), 
		SAUCE("005", "소스"),
		;
		
		private String code;
		private String value;
		
		Type(String code, String value){
			this.code = code;
			this.value = value;
		}
		
		public String getCode() {
			return this.code;
		}
		
		public String getValue() {
			return this.value;
		}
		
	}

}
