/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.service;

import com.kingland.eip.domain.RecordModel;

import java.util.List;

/**
 * @author KSC
 */
public interface RecordService {
    RecordModel findRecordByRanks(int ranks);

    List<RecordModel> findAllRecords();

    void addRecord(RecordModel recordModel);
}
