/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.mapper;

import com.kingland.eip.domain.RecordModel;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author KSC
 */
@Component
public interface RecordMapper {

    RecordModel findRecordByRanks(int ranks);

    List<RecordModel> findAllRecords();

    void addRecord(RecordModel recordModel);
}
