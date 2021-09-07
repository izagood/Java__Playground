package programmers_proj.problems.kakao.t2021;

public class NewId {
	public String solution(String new_id) {
		
        String answer = "";
        
        //1단계
        answer = new_id.toLowerCase();
        System.out.println(answer);
        
        //2단계
        String replaceAll = answer.replaceAll("[^\\W]", "");
//        String replaceAll = answer.replaceAll("\\p{Punct}", "");
//        String replaceAll = answer.replaceAll("^[^0-9]*$ & ^[^a-z]*$ & ^[^-_.]*$", "");
        System.out.println(replaceAll);
        
        //3단계
        
        
        
        //4단계
        
        //5단계
        
        //6단계
        int idLength = new_id.length();
        
        if(idLength >= 3 && idLength <= 15) {
        	
        }
        
        //7단계
        
        return answer;
    }
}
