package com.gg.assets.assets_management.history;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gg.assets.assets_management.ApiResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin("*")
@RestController
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    HistoryService historyService;

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<History>>> getAllHistories() {
        List<History> result =  historyService.getAllHistory();
        System.out.println(result);
        ApiResponse<List<History>> reponse = new ApiResponse<List<History>>(200, "GET ALL history", result);
        return ResponseEntity.status(HttpStatus.OK).body(reponse);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Long>> createHist(@RequestBody History newHist) {
        newHist.setTime(LocalDateTime.now());
        Long result =  historyService.createHisttHistory(newHist);
        ApiResponse<Long> reponse = new ApiResponse<Long>(200, "create history", result);
        return ResponseEntity.status(HttpStatus.OK).body(reponse);
    }


    @GetMapping("/hello")
    public String getMethodName() {
        return "Hello World";
    }
    
    
}
