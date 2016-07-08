package com.upsoft;

import com.google.common.collect.Collections2;
import com.upsoft.entity.HitResultsList;
import com.upsoft.service.GenericExecel;
import com.upsoft.service.HitResultsListService;
import com.upsoft.utils.DateFormatUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.shell.support.util.OsUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;

/**
 * @author xsTao
 * @date 2016/6/30 11:27
 * @see
 * @since 1.0
 */
@Component
public class ExportCommands  implements CommandMarker {
    protected final Logger LOG = Logger.getLogger(getClass().getName());
    @Autowired
    private HitResultsListService hitResultsListService;
    @Autowired
    private GenericExecel execelService;
    public static final String DEFUALT_LOCATION=getDefualtLocation();
    @CliAvailabilityIndicator({"export"})
    public boolean isExport() {
        return true;
    }

    @CliCommand(value = "export", help = "export hitResults to excel")
    public String export(
            @CliOption(key = { "filename" }, mandatory = true, help = "setting export excel filename")
             String filename,
            @CliOption(key = { "location" }, mandatory = false,
                    help = "setting export excel file location",
                    specifiedDefaultValue="")  String location,
            @CliOption(key = { "starttime" }, mandatory = false,
                    help = "setting export gt starttime",
                    specifiedDefaultValue="")  String starttime,
            @CliOption(key = { "title" }, mandatory = false,
                    help = "setting export title",
                    specifiedDefaultValue="")  String title
            ) {
        OutputStream out =null;
        if(StringUtils.isBlank(location)){
            location=DEFUALT_LOCATION;
        }
        String filePath=location+ File.separator+filename+".xls";
        long rowSize=0;
        try{
            LOG.info("handler start...");
            long startTime=0L;
            //验证时间格式
            if(StringUtils.isNotBlank(starttime)){
                try{
                    startTime= DateFormatUtil.format(starttime);
                }catch (Exception e){
                    return "startTime ParseException like ["+starttime+"] must to  yyyy-MM-dd ";
                }

            }
            HitResultsList list=new HitResultsList();
            list.setCreateTime(startTime);
            List<HitResultsList> resultLst= hitResultsListService.findALL(list);
            if(null!=resultLst&& resultLst.size()>0)
                rowSize=resultLst.size();
             out=new FileOutputStream(filePath);
             execelService.exportExcel("ccc",new String[]{},resultLst,out);
        }catch (Exception e){
            e.printStackTrace();
            return "export fail "+e.getMessage();
        }finally {
            if(null!=out) {
                try {
                    out.flush();
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        return "export success file at "+filePath+" , count="+rowSize;
    }
    public static String getDefualtLocation(){
        return System.getProperty("user.dir",File.separator);
    }
}
