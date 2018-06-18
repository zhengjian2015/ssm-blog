<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/myTag.tld" prefix="lyz" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <rapid:override name="breadcrumb">
       <nav class="breadcrumb">
           <div class="bull"><i class="fa fa-volume-up"></i></div>
           <div id="scrolldiv">
               <div class="scrolltext">
                   <ul style="margin-top: 0px;">
                   </ul>
               </div>
           </div>
       </nav>
   </rapid:override>
   
   
    <rapid:override name="left">
        <div id="primary" class="content-area">
            <main id="main" class="site-main" role="main">
                <c:forEach items="${pageInfo.list}" var="a">
                    <article  class="post type-post">
                        <figure class="thumbnail">
                            <a href="/article/${a.articleCustom.articleId}">
                                <img width="280" height="210"
                                     src="${pageContext.request.contextPath}/resource/assets/img/thumbnail/random/img_${a.articleCustom.articleId%400}.jpg"
                                     class="attachment-content size-content wp-post-image"
                                     alt="${a.articleCustom.articleTitle}">
                            </a>
                            <span class="cat">
                                <a href="">
                                    
                                </a>
                            </span>   

                        </figure>

                        <header class="entry-header">
                            <h2 class="entry-title">
                                <a href="/article/${a.articleCustom.articleId}"
                                   rel="bookmark">
                                        ${a.articleCustom.articleTitle}
                                </a>
                            </h2>
                        </header>

                        <div class="entry-content">
                            <div class="archive-content">
                                <lyz:htmlFilter>${a.articleCustom.articleContent}</lyz:htmlFilter>......
                            </div>
                            <span class="title-l"></span>
                            <span class="new-icon">
                                <c:choose>
                                    <c:when test="${a.articleCustom.articleStatus==2}">
                                        <i class="fa fa-bookmark-o"></i>
                                    </c:when>
                                    <c:otherwise>
                                        <jsp:useBean id="nowDate" class="java.util.Date"/>
                                        <c:set var="interval"
                                               value="${nowDate.time - a.articleCustom.articlePostTime.time}"/><%--时间差毫秒数--%>
                                        <fmt:formatNumber value="${interval/1000/60/60/24}" pattern="#0"
                                                          var="days"/>
                                        <c:if test="${days <= 7}">NEW</c:if>
                                    </c:otherwise>
                                </c:choose>
                            </span>
                            <span class="entry-meta">
                                <span class="date">
                                    <fmt:formatDate value="${a.articleCustom.articlePostTime}" pattern="yyyy年MM月dd日"/>
                                &nbsp;&nbsp;
                                </span>
                                <span class="views">
                                    <i class="fa fa-eye"></i>
                                        ${a.articleCustom.articleViewCount} views
                                </span>
                                <span class="comment">&nbsp;&nbsp;
                                    <a href="/article/${a.articleCustom.articleId}#comments" rel="external nofollow">
                                      <i class="fa fa-comment-o"></i>
                                        <c:choose>
                                            <c:when test="${a.articleCustom.articleCommentCount==0}">
                                                发表评论
                                            </c:when>
                                            <c:otherwise>
                                                ${a.articleCustom.articleCommentCount}
                                            </c:otherwise>
                                        </c:choose>

                                    </a>
                                </span>
                            </span>
                            <div class="clear"></div>
                        </div><!-- .entry-content -->

                        <span class="entry-more">
                                <a href="/article/${a.articleCustom.articleId}"
                                   rel="bookmark">
                                    阅读全文
                                </a>
                            </span>
                    </article>
                </c:forEach>
            </main>
            
            !-- 显示分页信息 -->
        <div class="row">
            <!--分页文字信息  -->
            <div class="col-md-6 pageMessage" id="page_info_area">当前 ${pageInfo.pageNum }页,总${pageInfo.pages }
                页,总 ${pageInfo.total } 条记录</div>
            <!-- 分页条信息 -->
            <div class="col-md-6" id="page_nav_area">
                <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="${pageContext.request.contextPath}/p?pn=1">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage }">
                        <li><a href="${pageContext.request.contextPath}/p?pn=${pageInfo.pageNum-1}"
                            aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                        </a></li>
                    </c:if>


                    <c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
                        <c:if test="${page_Num == pageInfo.pageNum }">
                            <li class="active"><a href="#">${page_Num }</a></li>
                        </c:if>
                        <c:if test="${page_Num != pageInfo.pageNum }">
                            <li><a href="${pageContext.request.contextPath}/p?pn=${page_Num }">${page_Num }</a></li>
                        </c:if>

                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage }">
                        <li><a href="${pageContext.request.contextPath}/p?pn=${pageInfo.pageNum+1 }"
                            aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                        </a></li>
                    </c:if>
                    <li><a href="${pageContext.request.contextPath}/p?pn=${pageInfo.pages}">末页</a></li>
                </ul>
                </nav>
            </div>
        </div>
            
        </div>   


    </rapid:override>
    
     <%--左侧区域 end--%>

    <%--侧边栏 start--%>
    <rapid:override name="right">
        <%@include file="Public/part/sidebar-2.jsp" %>
    </rapid:override>
    <%--侧边栏 end--%>
   
   <%@ include file="Public/framework.jsp" %>