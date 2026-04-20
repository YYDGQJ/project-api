package com.project.om.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.project.om.entity.Tom01;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Tom01InfoVO 合同信息返回对象
 *
 * @author YYDGQJ
 * 创建日期  2026/4/19
 * 描述
 */
@Data
public class Tom01InfoVO extends Tom01 {
}

