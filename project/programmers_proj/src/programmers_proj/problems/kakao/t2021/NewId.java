package programmers_proj.problems.kakao.t2021;

public class NewId {
	public String solution(String new_id) {
        String answer = "";
        //1단계
        answer = new_id.toLowerCase();
        
        //2단계
        answer.replaceAll("^[0-9]*$", "");
        
        return answer;
    }
}
