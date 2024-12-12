package com.team5.fandom.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.team5.fandom.dto.FandomDto;
import com.team5.fandom.dto.PostDto;
import com.team5.fandom.entity.value.Tag;
import com.team5.fandom.repository.FandomRepository;
import com.team5.fandom.repository.PostRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FandomService {

	private final FandomRepository fandomRepository;
	private final PostRepository postRepository;
	
	public List<FandomDto> getFandoms() {
//		System.out.println(fandomRepository.findAllByOrderByFandomExpAtASC());
		return fandomRepository.findAllByOrderByFandomExpDesc().stream().map(FandomDto::toFandomDto).toList();
	}
	
}
