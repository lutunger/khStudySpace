<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSTL 조건문</title>
</head>
<body>

    <h1>4. 조건문 - if  (c:if 태그) </h1>
    <pre>
        - 단독 if문 (c:else 없음!)

        - 속성은 test만 존재함

        *** 주의 사항 ***
        1) test의 속성 값은 무조건 EL 구문으로 작성해야 한다!!! 
                                                        -> c:out 도 .. el로 값을 넣었었다..
        2) test의 속성 값은 true 또는 false가 나오는 조건식이여야만 한다.
        3) test의 속성 값을 작성하는 "" 내부에는 앞뒤 공백이 존재해서는 안된다
                                                if(  a == b  )  -> 하면 안돼...
    </pre>

    request에 세팅된 name : ${name}     <%-- 홍길동 --%>
    <br>
    request에 세팅된 money : ${money}   <%-- 50000 --%>


    <br>
    <%-- !if --%>     <%--  "    ${ money == 50000 }   "  <- 이렇게 공백있으면 에러남,, 괄호안은 상관없음 --%>
    <c:if test="${ money == 50000 }">
        <h3 style="color:gold">돈이 5만원이 있습니다.</h3>
    </c:if>


    <h3>EL에서 모든 비교는 == 또는 eq /  != 또는 ne 사용 </h3>
    <h3>EL에서 문자열은 ''(홑따옴표)로 표현 </h3>

                <%-- java에선 equals를 썼지만... --%>
    <c:if test="${name == '홍길동'}">
    <%-- <c:if test="${name eq '홍길동'}"> --%>
    <%-- <c:if test="${name != '고길동'}"> --%>
    <%-- <c:if test="${name ne '고길동'}"> --%>
        <h3>이름이 일치합니다</h3>
    </c:if>

    <%-- else 역할 --%> <%-- else를 쓰면 구문실행이 안되는데... 이건 실행해야되니까 효율이 떨어진다, 대안으로 choose --%>
    <c:if test="${name ne '홍길동'}" >
        <h3>이름이 일치하지 않습니다</h3>
    </c:if>
    


    
</body>
</html>