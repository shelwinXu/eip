package com.kingland.eip.service;

import com.kingland.eip.domain.RecordModel;

import java.util.List;

public interface RecordService {
    RecordModel findRecordByRanks(int ranks);

    List<RecordModel> findAllRecords();
}
