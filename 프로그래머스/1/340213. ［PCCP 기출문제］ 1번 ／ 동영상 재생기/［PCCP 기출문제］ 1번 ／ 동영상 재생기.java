import java.util.*;

class Solution {
    // 시간을 초 단위로 변환하는 함수
    private int toSeconds(String time) {
        int minutes = Integer.valueOf(time.substring(0, 2));
        int seconds = Integer.valueOf(time.substring(3, 5));
        return minutes * 60 + seconds;
    }

    // 초를 "mm:ss" 형식으로 변환하는 함수
    private String toTimeFormat(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 각 시간들을 초 단위로 변환
        int videoSeconds = toSeconds(video_len);
        int posSeconds = toSeconds(pos);
        int opStartSeconds = toSeconds(op_start);
        int opEndSeconds = toSeconds(op_end);
        
        // 오프닝 구간일 경우 오프닝 끝으로 이동
        if (posSeconds >= opStartSeconds && posSeconds <= opEndSeconds) {
            posSeconds = opEndSeconds;
        }
        
        // 명령어들을 순서대로 처리
        for (String command : commands) {
            if (command.equals("prev")) {
                // 10초 전으로 이동, 0초 미만으로 내려가지 않도록 함
                posSeconds = Math.max(posSeconds - 10, 0);
            } else if (command.equals("next")) {
                // 10초 후로 이동, 영상 길이를 초과하지 않도록 함
                posSeconds = Math.min(posSeconds + 10, videoSeconds);
            }
            
            // 오프닝 구간일 경우 오프닝 끝으로 이동
            if (posSeconds >= opStartSeconds && posSeconds <= opEndSeconds) {
                posSeconds = opEndSeconds;
            }
        }

        // 최종 재생 위치를 "mm:ss" 형식으로 반환
        return toTimeFormat(posSeconds);
    }
}