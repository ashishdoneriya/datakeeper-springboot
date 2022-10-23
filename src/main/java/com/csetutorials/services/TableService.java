package com.csetutorials.services;

import com.csetutorials.repositories.TableInfoRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TableService {

	@Autowired
	TableInfoRepository tableInfoRepo;

	@Autowired
	JPAQueryFactory queryFactory;

}
