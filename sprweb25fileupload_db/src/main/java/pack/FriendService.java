package pack;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService {
	@Autowired
	private FriendRepository friendRepository;
	
	public void saveFriend(Friend friend) {
		friendRepository.save(friend);
	}
	
	public List<Friend> findAll(){
		//Friend를 모두 읽어 각 객체의 사진을 Base64로 변환후, 그 결과를 리스트에 저장.
		return friendRepository.findAll()
				.stream().map(this::convertToBase64).collect(Collectors.toList());
	}
	
	private Friend convertToBase64(Friend friend) {
		//사진을 Base64로 인코딩해서 DB에 저장
		if(friend.getSajin() != null && friend.getSajin().length >0) {
			String base64Image = Base64.getEncoder().encodeToString(friend.getSajin());
			friend.setBase64Image(base64Image);
		}
		return friend;
	}
	
	//bunho 증가
	private int generateBunho() {
		Integer lastBunho = friendRepository.findLastBunho();
		if(lastBunho == null) {
			return 1;
		}else {
			return lastBunho +2;
		}
	}
}
