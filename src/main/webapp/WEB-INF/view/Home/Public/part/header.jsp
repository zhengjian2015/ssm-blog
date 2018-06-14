<%--
    博客顶部部分
    包括：顶部菜单，主要菜单(包括搜索按钮)，面包屑
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%--搜索框 start--%>
<div id="search-main">
    <div class="searchbar">
        <form method="get" id="searchform" action="/search">
                <span>
                    <input type="text" value="" name="query" id="s" placeholder="输入搜索内容"required="">
                    <button type="submit" id="searchsubmit">搜索</button>
                </span>
        </form>
    </div>
    <div class="clear"></div>
</div>

<rapid:block name="breadcrumb"></rapid:block>