package com.upsoft.entity;

import java.io.Serializable;

/**
 * @author xsTao
 * @date 2016/6/30 11:23
 * @see
 * @since 1.0
 */

public class HitResultsList implements Serializable {
    private static final long serialVersionUID = 1430082073121442861L;

    public static final String STATUS_CREATE = "1";

    private String id;
    private String addressId;
    private String url;
    private String title;
    private String summary;
    private String text;
    private String parsetext;
    private String keywords;
    private String version;
    private String contentMeta;
    private String signature;
    private String status;// 0_忽略、1_创建、2_生成事件
    ////////////
    private Long pubDate;
    private Integer pageView;
    private String srcType;
    private String author;
    ////////////

    private Long createTime;
    private Long versionTime;

    private String ispolution;

    private String polutionType;

    private String polutionName;
    /**
     * 忽略
     */
    public static final String STATE_NOT_INGORE="0";
    /**
     * 创建
     */
    public static final String STATE_CREATE="1";
    /**
     * 上报
     */
    public static final String STATE_UPINGORE="2";
    /**
     * 生成事件
     */
    public static final String STATE_GENERIATE_EVENT="3";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getContentMeta() {
        return contentMeta;
    }

    public void setContentMeta(String contentMeta) {
        this.contentMeta = contentMeta;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getVersionTime() {
        return versionTime;
    }

    public void setVersionTime(Long versionTime) {
        this.versionTime = versionTime;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getParsetext() {
        return parsetext;
    }

    public void setParsetext(String parsetext) {
        this.parsetext = parsetext;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
    /**
     * @return the pubDate
     */
    public Long getPubDate() {
        return pubDate;
    }

    /**
     * @param pubDate the pubDate to set
     */
    public void setPubDate(Long pubDate) {
        this.pubDate = pubDate;
    }

    /**
     * @return the pageView
     */
    public Integer getPageView() {
        return pageView;
    }

    /**
     * @param pageView the pageView to set
     */
    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    /**
     * @return the srcType
     */
    public String getSrcType() {
        return srcType;
    }

    /**
     * @param srcType the srcType to set
     */
    public void setSrcType(String srcType) {
        this.srcType = srcType;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIspolution() {
        return ispolution;
    }

    public void setIspolution(String ispolution) {
        this.ispolution = ispolution;
    }

    public String getPolutionType() {
        return polutionType;
    }

    public void setPolutionType(String polutionType) {
        this.polutionType = polutionType;
    }

    public String getPolutionName() {
        return polutionName;
    }

    public void setPolutionName(String polutionName) {
        this.polutionName = polutionName;
    }
}