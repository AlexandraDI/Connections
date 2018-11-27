<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<div class="col-md-7">  

     <%-- Keep a reference to the size of the collection --%>
    <c:set var="number" value="${fn:length(conarticlelist)}" />   

    <c:forEach var = "i" begin = "1" end = "${number}" step= "1">
          <c:set var="article" value="${conarticlelist[number-i]}" />    
        <div class="single-news-p1-cont" style="margin-bottom: 30px; box-shadow: 1px 1px 1px rgba(0,0,0,0.1);">
            <div class="single-news-img">
                <img src="img/news/news-box-1.jpg" alt="" class="img-fluid">
            </div>


            <div class="single-news-desc m-0 pt-1 pb-0 px-0">
                <h3> ${article.title}</h3>
                <ul class="list-inline">
                    <li>Posted: <span class="text-theme-colored2"> ${article.datetimeCreated}</span></li>
                    <li>By: <span class="text-theme-colored2">${article.authorId.firstname} ${article.authorId.surname}</span></li>
                </ul>
                <hr>
                <div class="bg-light-gray">                   
                    <p>
                        ${article.content}
                    </p> 
                    <a href="${pageContext.request.contextPath}/details?articleid=${article.articleId}" class="mb-2">Read More <i class="fa fa-long-arrow-right"></i></a>
                </div> 
            </div>
        </div>
    </c:forEach>    
</div>  