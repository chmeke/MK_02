package org.java.service.impl;

import org.java.dao.ShowGoodsMapper;
import org.java.service.ShowGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service("showgoods")
public class ShowGoodsServiceImpl implements ShowGoodsService {
    @Autowired
    private ShowGoodsMapper mapper;

    @Override
    public List<Map> showgoods() {
        return mapper.showgoods();
    }
}
