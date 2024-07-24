package pack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pack.dto.MemberDto;
import pack.entity.Member;
import pack.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberServiceInter{
	@Autowired
	private MemberRepository memRepository;
	
	@Override
	public void getList(Model model) {
	/*
		// 방법1. member 전체 자료 반환: 기본 메소드 사용
		// Member 엔티티를 MemberDto객체로 전달
		List<Member> entityList = memRepository.findAll();
		
		List<MemberDto> list = new ArrayList<MemberDto>(); //멤버dto로 넘길것
		for(Member temp:entityList) {
			MemberDto dto = new MemberDto();
			dto.setNum(temp.getNum());
			dto.setName(temp.getName());
			dto.setAddr(temp.getAddr());
			list.add(dto); //Member(엔티티) entityList > MemberDto(디티오) list 에 넣어줌.
		}
	*/
		
		// 방법2. List<Member>를, Stream으로 변경해서 map()을 사용해, List<MemberDto>로 변경하기.
		List<MemberDto> list = memRepository.findAllByOrderByNumDesc()
											.stream()
											.map(item -> MemberDto.toDto(item)).toList();
	/*	
		// 방법3. 람다 표현식을 메소드참조표현식으로 기술. 클래스명::메소드명
		List<MemberDto> list2 = memRepository.findAllByOrderByNumDesc()
											.stream()
											.map(MemberDto::toDto).toList();
	*/	
		model.addAttribute("list", list); //컨트롤러에 MemberDto가 담긴 list 전달
		
		
	}
	@Override
	public void insert(MemberDto dto) {//dto이기에 엔티티로 변환작업요.
		//Jpa 작업영역내로 들어갈때 일반자료전달용객체(dto, FormBean)를 대응 entity로 변환.
		memRepository.save(Member.toEntity(dto));
		
	}
	//수정 자료 읽기
	@Override
	public void getData(Long num, Model model) { //모델을 갖고온이유. model은 스프링이관리함. 그래서 void여도 괜찮음.
		Member m = memRepository.findById(num).get(); //엔티티가져옴
		
		model.addAttribute("dto", MemberDto.toDto(m));// 엔티티 > 디티오작업

	}
	@Override
	public void update(MemberDto dto) {
		memRepository.save(Member.toEntity(dto)); //디티오 > 엔티티작업
		
	}
	@Override
	public void update2(MemberDto dto) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Long num) {
		memRepository.deleteById(num);
		
	}
	
}
