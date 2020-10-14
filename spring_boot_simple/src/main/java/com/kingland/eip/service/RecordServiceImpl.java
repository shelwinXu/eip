package com.kingland.eip.service;

import com.kingland.eip.domain.RecordModel;
import com.kingland.eip.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecordServiceImpl implements RecordService{

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public RecordModel findRecordByRanks(int ranks) {
        return recordMapper.findRecordByRanks(ranks);
    }

    @Override
    public List<RecordModel> findAllRecords() {
        return recordMapper.findAllRecords();
    }
}
