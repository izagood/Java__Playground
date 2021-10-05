package programmers_proj.problems.kakao.t2021;

public class NewId {
	public String solution(String new_id) {
		
        String answer = "";
        //5단계
        if("".equals(new_id)) {
        	return "a";
        }
        
        //1단계
        answer = new_id.toLowerCase();
        System.out.println(answer);
        
        //2단계
        String[] Strarr = {"`", "~", "!", "@", "#",
        				   "$", "%", "^", "&", "*",
        				   "(", ")", "+", "=", "?",
        				   "/", "{", "}", ";", ":",
        				   "'", "\"", "\\", "[", "]",
        				   ",", "<", ">"}; // - _ . 만 허용
        
        for(String str: Strarr) {
        	
        	String replace = answer.replaceAll(str, "");
        	answer = replace;
        	
        	System.out.println(answer);
        }
        
        System.out.println("2단계 끝 : " + answer);
        
        //3단계
        
        
        
        //4단계
        
        
        //6단계
//        int idLength = new_id.length();
//        
//        if(idLength >= 3 && idLength <= 15) {
//        	
//        }
        
        //7단계
        
        return answer;
    }
}
