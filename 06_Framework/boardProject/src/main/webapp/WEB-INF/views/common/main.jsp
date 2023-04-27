<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 프로젝트</title>
    
    <%-- <link rel="stylesheet" href="/resources/css/main-style.css">

    <!-- font awesome 라이브러리 추가 + key 등록 -->
    <script src="https://kit.fontawesome.com/f7459b8054.js" crossorigin="anonymous"></script> --%>
</head>
<body>
    <%-- <link rel="stylesheet" href="/resources/css/main-style.css">

    <!-- font awesome 라이브러리 추가 + key 등록 -->
    <script src="https://kit.fontawesome.com/f7459b8054.js" crossorigin="anonymous"></script> --%>

    <main>
        
        <%-- header.jsp 추가(포함) --%>

        <%-- 
            <jsp:include page="jsp파일경로" /> 

            - JSP 액션 태그 (JSP에 기본 내장된 태그)
            - 다른 jsp 파일의 코드를 현재 위치에 추가(포함)
            - jsp 파일 경로는 webapp 폴더를 기준으로 작성
        --%>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <section class="content">
            <section class="content-1">

                <h3>로그인된 회원 정보</h3>
                
                ${sessionScope.loginMember}

            </section>

            <section class="content-2">
                

                <c:choose>

                    <%--  
                        c:choose 내부에는 c:when, c:otherwise, jsp 주석만 작성 가능
                        c:when, c:otherwise 내부에는 다른 코드 작성 가능!
                    --%>
                    
                    <%-- EL empty 연산자 : 비어 있거나 null 이면 true --%>
                    <c:when test="${empty sessionScope.loginMember}">

                        <form action="/member/login" method="post" id="loginFrm">

                            <fieldset class="id-pw-area">
                                <section>
                                    <input type="text" name="memberEmail" 
                                    placeholder="이메일" autocomplete="off" value="${cookie.saveId.value}">
                                    <input type="password" name="memberPw" placeholder="비밀번호">
                                </section>
                                <section>
                                    <button>로그인</button>
                                </section>
                            </fieldset>

                            <label>
                                <%-- <c:if test="${empty cookie.saveId.value}" >
                                    <input type="checkbox" name="saveId" > 아이디 저장
                                </c:if>

                                <c:if test="${not empty cookie.saveId.value}" >
                                    <input type="checkbox" name="saveId" checked> 아이디 저장
                                </c:if> --%>

                                <c:if test="${not empty cookie.saveId.value}" >
                                    <%-- 쿠키에 저장된 이메일이 있으면 save 변수 선언 
                                        -> page scope (페이지 내에서 사용 가능, if문 끝나도 가능!)
                                    --%>
                                    <c:set var="save" value="checked"/>
                                </c:if>

                                <input type="checkbox" name="saveId" ${save}> 아이디 저장


                            </label>

                            <article class="signup-find-area">
                                <a href="#">친구되기</a>
                                <span>|</span>
                                <a href="#">나 친구맞아! 나 몰라?</a>
                            </article>

                        </form>

                    </c:when>



                    <%-- 로그인 되었을 때 --%>
                    <c:otherwise>
                        <article class="login-area">

                            <a href="#">
                                <img src="/resources/images/user.png" id="memberProfile">
                            </a>

                            <div class="my-info">
                                <div>
                                    <a href="#" id="nickname">${sessionScope.loginMember.memberNickname}</a>

                                    <a href="/member/logout" id="logoutBtn">로그아웃</a>
                                </div>

                                <p>${loginMember.memberEmail}</p>

                            </div>


                        </article>
                    </c:otherwise>

                </c:choose>




            </section>

        </section>
    </main>

    <%-- footer --%>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>


    <!-- main.js 추가 -->
    <script src="/resources/js/main.js"></script>
    
</body>
</html>