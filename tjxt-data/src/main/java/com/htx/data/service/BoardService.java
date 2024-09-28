package com.htx.data.service;


import com.htx.data.model.dto.BoardDataSetDTO;
import com.htx.data.model.vo.EchartsVO;

import java.util.List;

public interface BoardService {

    /**
     * 看板数据获取
     *
     * @param types 数据类型
     * @return
     */
    EchartsVO boardData(List<Integer> types);

    /**
     * 设置看板数据
     *
     * @param boardDataSetDTO
     */
    void setBoardData(BoardDataSetDTO boardDataSetDTO);
}