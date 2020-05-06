
class Solution {
	public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        // 자식, 부모
        HashMap<Long, Long> map = new HashMap<>();
        
        for(int i=0; i<room_number.length; i++) {
        	// i 번째 손님이 방문합니다!
        	ArrayList<Long> list = new ArrayList<>();
        	long room = room_number[i];
        	
        	if(!map.containsKey(room)) { // 방이 비어있다!
        		map.put(room, room+1);
        		answer[i] = room;
        	}
        	else { // 방이 비어있지않다...
        		// 부모 가져오기
        		long parent = map.get(room);
        		list.add(room);
        		while(true) {
        			// 빈 방을 찾아나선다...
        			if(!map.containsKey(parent)) { // 드디어 빈방 도착!
        				map.put(parent, parent+1);	// 빈방 추가하고
        				answer[i] = parent;
        				break;
        			}
        			else {
        				list.add(parent);	// 내가 방문했던 애들 다 부모를 업데이트 시켜야 하니깐.....
        				parent = map.get(parent);
        			}
        		}
        		
        		for(int j = 0; j<list.size(); j++)
        			map.replace(list.get(j), parent+1);
        	}
        }
        return answer;
    }



	/*
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        HashMap <Long, Long> hash = new HashMap();
        ArrayList<Long> list = new ArrayList<>();
        for(int i=0; i<room_number.length; i++) { // i번째 손님이 방문합니다~
        	if(!hash.containsKey(room_number[i])) { // 비어있으면.
        		answer[i] = room_number[i]; 
 
        		long room = room_number[i]; // 나 
        		long currentRoom = room + 1; // 나의 부모
        		
        		while(true) {
        			if(!hash.containsKey(currentRoom)){ // 부모 방이 비었따...
        				hash.put(room, currentRoom);
        				break;
        			}else { // 부모방이 안비었어.. 그러면 부모를 부모의 부모로 이동할 거야.
        				currentRoom = hash.get(currentRoom); // 5	
        			}       	
        		}
        		
        	}
        	else { // 비어있지않다...
        		long room = room_number[i]; // 나
        		long currentRoom = hash.get(room_number[i]); // 나의 부모
        		while(true) {
        			if(!hash.containsKey(currentRoom)){ // 부모 방이 비었따...
        				answer[i] = currentRoom;
        				
        				if(!hash.containsKey(currentRoom+1)) { // 새로 넣은 나의 방의 새로운 부모가 비었으면.
            				hash.replace(room, currentRoom+1);
            				hash.put(currentRoom, currentRoom+1);
        				}else { // 얘가 차있으면 얘의 부모를 넣을거야! // 근데 이 경우에는 얘가 맨 앞이 줄줄 또 연결된 경우잖아.
        					hash.replace(room, hash.get(currentRoom+1));
            				hash.put(currentRoom, hash.get(currentRoom+1));
        				}
        			        				
        				break;
        			}else { // 부모방이 안비었어.. 그러면 부모를 부모의 부모로 이동할 거야.
        				currentRoom = hash.get(currentRoom); 
        			}       	
        		}
        	}
        }	
        return answer;
    }  
    */
}