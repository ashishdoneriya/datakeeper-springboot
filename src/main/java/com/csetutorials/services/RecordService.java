package com.csetutorials.services;

import com.csetutorials.models.AutoGeneratedIdRecord;
import com.csetutorials.repositories.AutoGeneratedIdRecordRepository;
import com.csetutorials.repositories.CustomIdRocordRepository;
import com.csetutorials.repositories.TableInfoRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RecordService {

	@Autowired
	AutoGeneratedIdRecordRepository autoIdRepo;

	@Autowired
	CustomIdRocordRepository customIdRepo;

	@Autowired
	TableInfoRepository tableInfoRepo;

	@Autowired
	JPAQueryFactory queryFactory;

}
