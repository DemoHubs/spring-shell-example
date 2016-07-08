package com.upsoft.service;

import java.io.OutputStream;
import java.util.Collection;

/**
 * @author xsTao
 * @date 2016/6/30 13:36
 * @see
 * @since 1.0
 */
public interface GenericExecel {

    public void exportExcel(String title,String[] headers,Collection dataset,OutputStream out);
}
