import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    // 열(Column) 인덱스를 정의하는 enum
    public enum Column{
        CODE(0), DATE(1), MAXIMUM(2), REMAIN(3);
        
        private int index;
        
        Column(int index){
            this.index = index;
        }
        
        public int getIndex(){
            return index;
        }
    }
    
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 필터링 기준과 정렬 기준에 해당하는 열 인덱스 추출
        int filterIndex = Column.valueOf(ext.toUpperCase()).getIndex();
        int sortIndex = Column.valueOf(sort_by.toUpperCase()).getIndex();
        
        // 조건에 맞는 데이터를 필터링하고 정렬
        return Arrays.stream(data)
            .filter(row -> row[filterIndex] < val_ext)  // 조건에 맞는 데이터 필터링
            .sorted(Comparator.comparingInt(row -> row[sortIndex]))  // 정렬 수행
            .collect(Collectors.toList());  // List로 변환
        
    }
}