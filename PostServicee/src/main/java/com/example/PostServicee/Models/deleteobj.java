package com.example.PostServicee.Models;

import java.util.List;

import lombok.Data;

@Data
public class deleteobj {
    private List<Long> deletelist;

    public deleteobj(List<Long> list){
        this.deletelist=list;
    }

}
