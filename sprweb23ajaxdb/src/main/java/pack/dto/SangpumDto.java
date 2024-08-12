package pack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Sangpum;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SangpumDto {
	private int code;
	private String sang, su, dan;
	
	public static SangpumDto toDto(Sangpum sangpum) {
		return SangpumDto.builder()
				.code(sangpum.getCode())
				.sang(sangpum.getSang())
				.su(sangpum.getSu())
				.dan(sangpum.getDan())
				.build();
	}
}
