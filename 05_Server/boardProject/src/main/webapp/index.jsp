<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 프로젝트</title>
    
    <link rel="stylesheet" href="/resources/css/main-style.css">

    <!-- font awesome 라이브러리 추가 + key 등록 -->
    <script src="https://kit.fontawesome.com/f7459b8054.js" crossorigin="anonymous"></script>
</head>
<body>

    <main>
        <header>
            <section>
                <!-- 클릭 시 메인 페이지로 이동하는 로고 -->
                <a href="#">
                    <img src="/resources/images/뽀로로2.jpg" alt="노는게 제일 좋아" id="homeLogo">
                </a>
            </section>


            <section>
                <!-- 검색어 입력할 수 있는 요소 배치 -->

                <article class="search-area">

                    <!-- 
                        action : 내부 input에 작성된 값을 제출할 경로/주소 
                        method : 어떤 방식으로 제출할지 지정

                        - GET   : input태그 값을 주소에 담아서 제출(주소에 보임)
                        - POST  : input태그 값을 주소에 담지 않고 제출(주소에 안보임)
                                -> HTTP Body에 담아서 제출
                    -->
                    <form action="#" method="GET">
                        
                        <fieldset> <!-- form태그 내 영역 구분 -->
                            
                            <!-- 
                                input의 name 속성 == 제출 시 key 값
                                input에 입력된 내용 == 제출 시 value

                                autocomplete="off" : 브라우저 제공 자동완성 off
                            -->
                            <input type="search" name="query" id="query"
                            placeholder="뽀로로한테 시켜봐요!"
                            autocomplete="off">

                            <!-- 검색 버튼 -->
                            <!-- button type="submit" 이 기본값 -->
                            <button id="searchBtn" class="fa-sharp fa-solid fa-paw"></button>
                        </fieldset>

                    </form>

                </article>

            </section>
            <section></section>
        </header>

        <nav>
            <ul>
                <li><a href="#">공지사항</a></li>
                <li><a href="#">자유 게시판</a></li>
                <li><a href="#">질문 게시판</a></li>
                <li><a href="#">FAQ</a></li>
                <li><a href="#">1:1문의</a></li>
            </ul>
        </nav>

        <section class="content">
            <section class="content-1">

                <h3>로그인된 회원 정보</h3>
                

            </section>

            <section class="content-2">
                
                <form action="/member/login" method="post" id="loginForm">

                    <fieldset class="id-pw-area">
                        <section>
                            <input type="text" name="inputEmail" placeholder="이메일" autocomplate="off" >
                            <input type="password" name="inputPw" placeholder="비밀번호">
                        </section>
                        <section>
                            <button>로그인</button>
                        </section>
                    </fieldset>

                    <label>
                        <input type="checkbox" name="saveId"> 아이디 저장
                    </label>

                    <article class="signup-find-area">
                        <a href="#">친구되기</a>
                        <span>|</span>
                        <a href="#">나 친구맞아! 나 몰라?</a>
                    </article>

                </form>

            </section>

        </section>
    </main>

    <footer>
        <!-- © -->
        <p>Copyright &copy; KH Information Educational Institute A-Class</p>

        <article>
            <a href="#">프로젝트 소개</a>
            <span>|</span>
            <a href="#">이용약관</a>
            <span>|</span>
            <a href="#">개인정보처리방침</a>
            <span>|</span>
            <a href="#">고객센터</a>
        </article>

    </footer>
    
</body>
</html>