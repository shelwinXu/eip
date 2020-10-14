package com.kingland.eip.controller;

import com.kingland.eip.domain.RecordModel;
import com.kingland.eip.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChampionRecordController {
    @Autowired
    private RecordService recordService;

    @RequestMapping(value = "/api/findRecordByRanks/{ranks}", method = RequestMethod.GET)
    public RecordModel findRecordByRanks(@PathVariable int ranks) {
        return recordService.findRecordByRanks(ranks);
    }

    @RequestMapping(value = "/api/findALLRecords", method = RequestMethod.GET)
    public List<RecordModel> findAllRecords() {
        return recordService.findAllRecords();
    }
}
