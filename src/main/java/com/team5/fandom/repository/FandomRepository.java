package com.team5.fandom.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team5.fandom.dto.FandomDto;
import com.team5.fandom.entity.Fandom;

@Repository
public interface FandomRepository extends JpaRepository<Fandom, Integer> {

	List<Fandom> findAllByOrderByFandomExpAsc();

	List<Fandom> findAllByOrderByFandomExpDesc();

}
