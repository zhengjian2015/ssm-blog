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
   
   <%@ include file="Public/framework.jsp" %>