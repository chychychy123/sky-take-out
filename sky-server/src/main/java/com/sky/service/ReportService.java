package com.sky.service;

import com.sky.vo.OrderReportVO;
import com.sky.vo.SalesTop10ReportVO;
import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;

import java.time.LocalDate;

public interface ReportService {
    //统计指定时间区间内的营业额数据
    TurnoverReportVO getTurnoverStatistics(LocalDate begin, LocalDate end);


    //统计指定时间区间内的用户数据
    UserReportVO getUserStatistics(LocalDate begin, LocalDate end);
    //统计指定时间区间内的订单数据
    OrderReportVO getOrderStatistics(LocalDate begin, LocalDate end);

    SalesTop10ReportVO getSalesTop10(LocalDate begin, LocalDate end);
}

