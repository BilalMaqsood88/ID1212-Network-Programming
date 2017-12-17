<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  @author acer
--%>
<html>
<head>
    <title>Currency Exchange Application</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <link href="/HomeWork4/webapp/css/main.css" rel="stylesheet" />
</head>
<body>
<div id="wrapper">
    <div class="welcome"> Currency Exchange Application</div>
    <p></p>
    <div id="column1">
        <h2 style =" text-align : center"> Currency Information Menu </h2>
        <div class="col_div">
            <p></p>
            <p></p>
            <img src="/HomeWork4/webapp/images/currency.png" width="200px" height="200px" alt="" srcset="">
        </div>

        <div style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align:center;">
            <input class="btn_click" type="button"  onclick="location.href='/HomeWork4/api/currency'" value="Currency Menu" >
        </div>
    </div>
    <div id="column2">
        <h2 style =" text-align : center"> Exchange Rate Information Menu </h2>
        <div class="col_div">
            <div class="col_div">
                <p></p>
                <p></p>
                <img src="/HomeWork4/webapp/images/rate.png" width="200px" height="200px" alt="" srcset="">
            </div>

        </div>
        <div style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align:center;">
            <input class="btn_click" type="button"  onclick="location.href='/HomeWork4/api/rate'" value="Exchange Rate Menu" >
        </div>
    </div>

    <div id="column3">
        <h2 style =" text-align : center"> Exchange Currency Menu</h2>
        <div class="col_div">
            <p></p>
            <p></p>
                <img src="/HomeWork4/webapp/images/exchange.png" width="200px" height="200px" alt="" srcset="">
        </div>
        <div style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align:center;">
            <input class="btn_click" type="button"  onclick="location.href='/HomeWork4/api/currencyExchange'" value="Exchange Currency Menu" >
        </div>
    </div>
</div>
</body>
</html>
