/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.controller;

import com.kingland.eip.domain.RecordModel;
import com.kingland.eip.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author KSC
 */
@RestController
public class ChampionRecordController {
    @Autowired
    private RecordService recordService;

    @Cacheable
    @RequestMapping(value = "/api/findRecordByRanks/{ranks}", method = RequestMethod.GET)
    public RecordModel findRecordByRanks(@PathVariable int ranks) {

        return recordService.findRecordByRanks(ranks);
    }

    @Cacheable
    @RequestMapping(value = "/api/findALLRecords", method = RequestMethod.GET)
    public List<RecordModel> findAllRecords() {
        return recordService.findAllRecords();
    }

    @Cacheable
    @RequestMapping(value = "/api/addRecord", method = RequestMethod.POST)
    public void addRecord(RecordModel recordModel) {
        recordService.addRecord(recordModel);
    }
}