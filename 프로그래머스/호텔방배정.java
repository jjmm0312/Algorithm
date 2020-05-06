
class Solution {
	public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        // �ڽ�, �θ�
        HashMap<Long, Long> map = new HashMap<>();
        
        for(int i=0; i<room_number.length; i++) {
        	// i ��° �մ��� �湮�մϴ�!
        	ArrayList<Long> list = new ArrayList<>();
        	long room = room_number[i];
        	
        	if(!map.containsKey(room)) { // ���� ����ִ�!
        		map.put(room, room+1);
        		answer[i] = room;
        	}
        	else { // ���� ��������ʴ�...
        		// �θ� ��������
        		long parent = map.get(room);
        		list.add(room);
        		while(true) {
        			// �� ���� ã�Ƴ�����...
        			if(!map.containsKey(parent)) { // ���� ��� ����!
        				map.put(parent, parent+1);	// ��� �߰��ϰ�
        				answer[i] = parent;
        				break;
        			}
        			else {
        				list.add(parent);	// ���� �湮�ߴ� �ֵ� �� �θ� ������Ʈ ���Ѿ� �ϴϱ�.....
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
        for(int i=0; i<room_number.length; i++) { // i��° �մ��� �湮�մϴ�~
        	if(!hash.containsKey(room_number[i])) { // ���������.
        		answer[i] = room_number[i]; 
 
        		long room = room_number[i]; // �� 
        		long currentRoom = room + 1; // ���� �θ�
        		
        		while(true) {
        			if(!hash.containsKey(currentRoom)){ // �θ� ���� �����...
        				hash.put(room, currentRoom);
        				break;
        			}else { // �θ���� �Ⱥ����.. �׷��� �θ� �θ��� �θ�� �̵��� �ž�.
        				currentRoom = hash.get(currentRoom); // 5	
        			}       	
        		}
        		
        	}
        	else { // ��������ʴ�...
        		long room = room_number[i]; // ��
        		long currentRoom = hash.get(room_number[i]); // ���� �θ�
        		while(true) {
        			if(!hash.containsKey(currentRoom)){ // �θ� ���� �����...
        				answer[i] = currentRoom;
        				
        				if(!hash.containsKey(currentRoom+1)) { // ���� ���� ���� ���� ���ο� �θ� �������.
            				hash.replace(room, currentRoom+1);
            				hash.put(currentRoom, currentRoom+1);
        				}else { // �갡 �������� ���� �θ� �����ž�! // �ٵ� �� ��쿡�� �갡 �� ���� ���� �� ����� ����ݾ�.
        					hash.replace(room, hash.get(currentRoom+1));
            				hash.put(currentRoom, hash.get(currentRoom+1));
        				}
        			        				
        				break;
        			}else { // �θ���� �Ⱥ����.. �׷��� �θ� �θ��� �θ�� �̵��� �ž�.
        				currentRoom = hash.get(currentRoom); 
        			}       	
        		}
        	}
        }	
        return answer;
    }  
    */
}