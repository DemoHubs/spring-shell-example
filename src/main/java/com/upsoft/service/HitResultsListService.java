package com.upsoft.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.upsoft.entity.HitResultsList;
import com.upsoft.utils.ConditionResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author xsTao
 * @date 2016/6/30 11:25
 * @see
 * @since 1.0
 */
@Service
public class HitResultsListService {
    enum  QueryType{
        COUNT,LIST;
    }
    @Autowired
    private JdbcTemplate jdbcT;
    public void setJdbcT(JdbcTemplate jdbcT) {
        this.jdbcT = jdbcT;
    }
    public List findALL(HitResultsList params) {
        ConditionResult re= getResult(params,QueryType.LIST);
        List<Map<String, Object>> lst=jdbcT.queryForList(re.getSql(),re.getParamsArray());
        List<HitResultsList> root= Lists.newArrayList();
        if (lst.size()>0){
            for(int i=0;i<lst.size();i++) {
                HitResultsList result=new HitResultsList();
                Map map=lst.get(i);
                result.setId(Objects.toString(map.get("id"), StringUtils.EMPTY));
                result.setTitle(Objects.toString(map.get("title"), StringUtils.EMPTY));
                result.setUrl(Objects.toString(map.get("url"), StringUtils.EMPTY));
                result.setIspolution(Objects.toString(map.get("ispolution"), StringUtils.EMPTY));
                result.setPolutionName(Objects.toString(map.get("polution_name"), StringUtils.EMPTY));
                result.setPolutionType(Objects.toString(map.get("polution_type"), StringUtils.EMPTY));
                result.setText(Objects.toString(map.get("text"), StringUtils.EMPTY));
                root.add(result);
            }
        }
        return root;
    }
    public int findCount(HitResultsList params) {
        ConditionResult re= getResult(params,QueryType.COUNT);
        return jdbcT.queryForObject(re.getSql(),Integer.class);
    }
    private ConditionResult getResult(HitResultsList params,QueryType type){
        StringBuffer  sql = new StringBuffer();
        if(type.equals(QueryType.LIST)){
           sql.append("select  id,title,url,ispolution,polution_name," +
                    "polution_type,text,createTime" +
                    "   from hitresults_list where 1=1 ");
        }else{
            sql.append( "select count(1) from hitresults_list where 1=1");
        }
       List<Object> paramsList=Lists.newArrayList();
        if(null != params) {
            if (null != params.getCreateTime() && 0L != params.getCreateTime()) {
                sql.append(" and  createTime > ?");
                paramsList.add(params.getCreateTime());
            }
            if (StringUtils.isNotBlank(params.getTitle())) {
                sql.append(" and  title  = ?");
                paramsList.add(params.getTitle());
            }
        }
        return new ConditionResult(sql.toString(),paramsList.toArray(new Object[]{}));
    }
}
