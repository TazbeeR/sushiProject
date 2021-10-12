<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sushi parlour</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../fonts/gooddog.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,700&display=swap" rel="stylesheet">
    <link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css" rel="stylesheet">
    <link rel="stylesheet" href="../../css/style1.css">
    <link rel="stylesheet" href="../../css/animate.css">
</head>
<!-------------------------------------- BODY ------------------------------------------>

<body>
<div class="wrapper">
    <section class="container1">
        <header>
            <ul class="menu wow slideInDown" id="menu">
                <li class="link1"><a href="/">start</a></li>
                <li class="link2"><a href="/product/list">menu</a></li>
                <li class="link3"><a href="/basket/list">koszyk</a></li>
                <li class="link4"><a href="/contact">kontakt</a></li>
            </ul>
            <%--            <span class="burger" id="burger">--%>
            <%--                    <i></i>--%>
            <%--                    <i></i>--%>
            <%--                    <i></i>--%>
            <%--                </span>--%>
        </header>
        <div class="center1">
            <div class="text1">
                <img src="../../img/logo.png" alt="logo">
                <h2>new opening<br><span>23rd sept</span></h2>
                <%--                <span class="more">--%>
                <%--                        <h3>learn more</h3>--%>
                <%--                    </span>--%>
            </div>
        </div>
    </section>
    <section class="container2">
        <div class="text">
            <h3>Kontakt</h3>
            <p>
                Robert Myszkiewicz<br />
                Tel. 506 650 394 <br />
                Email <a href="mailto:myszkiewicz.rober81@gmail.com">myszkiewicz.rober81@gmail.com</a>

            </p>
        </div>
    </section>
    <section class="container3">
        <div class="item">
            <div class="photo">
                <img class="wow bounce" data-wow-duration="2s" src="../../img/item.png" alt="photo">
                <h3>New tastes</h3>
                <p>
                    Lorem ipsum dolor sit amet, consecte
                    sectetur adipisicing elit, tation omne
                    ullamco laboris nisi ut aliqolore.
                </p>
            </div>
        </div>
        <div class="item">
            <div class="photo">
                <img class="wow bounce" data-wow-duration="2s" src="../../img/item.png" alt="photo">
                <img class="wow bounce" data-wow-duration="2s" src="../../img/item.png" alt="photo">
                <h3>New dishes cooking</h3>
                <p>
                    Lorem ipsum dolor sit amet, consecte
                    sectetur adipisicing elit, tation omne
                    ullamco laboris nisi ut aliqolore.
                </p>
            </div>
        </div>
        <div class="item">
            <div class="photo">
                <img class="wow bounce" data-wow-duration="2s" src="../../img/item.png" alt="photo">
                <img class="wow bounce" data-wow-duration="2s" src="../../img/item.png" alt="photo">
                <img class="wow bounce" data-wow-duration="2s" src="../../img/item.png" alt="photo">
                <h3>New restaurant</h3>
                <p>
                    Lorem ipsum dolor sit amet, consecte
                    sectetur adipisicing elit, tation omne
                    ullamco laboris nisi ut aliqolore.
                </p>
            </div>
        </div>
    </section>

    <section class="container9" id="contact">
        <div class="caption">
            <h2 class="wow bounce" data-wow-duration="2s">“</h2>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                sed do eiusmod tempor incididunt ut labore et dolore
                magna aliqua. Ut enim ad minim veniam, quis
            </p>
            <h3>Linda Steward</h3>
        </div>
        <div class="content">
            <div class="item">
                <a href="#"><i id="facebook" class="fab fa-facebook-f"></i></a>
            </div>
            <div class="item">
                <a href="#"><i id="twitter" class="fab fa-twitter"></i></a>
            </div>
            <div class="item">
                <a href="#"><i id="instagram" class="fab fa-instagram"></i></a>
            </div>
            <div class="item">
                <a href="#"><i id="pinterest" class="fab fa-pinterest-p"></i></a>
            </div>
            <div class="item">
                <a href="#"><i id="google-plus" class="fab fa-google-plus-g"></i></a>
            </div>
        </div>
    </section>
    <footer>
        <div class="content">
            <div class="caption">
                <h3>about</h3>
                <p>Lorem ipsum dolor sit amet, consec
                    tetur adipisicing elit, sed do eiumod
                    tempor incididunt ultimam
                </p>
            </div>
            <div class="text">
                <div class="item">
                    <h4>about</h4>
                    <ul>
                        <li><a href="#">Team</a></li>
                        <li><a href="#">Join us</a></li>
                        <li><a href="#">Ethic</a></li>
                        <li><a href="#">Goals</a></li>
                    </ul>
                </div>
                <div class="item">
                    <h4>about</h4>
                    <ul>
                        <li><a href="#">Team</a></li>
                        <li><a href="#">Join us</a></li>
                        <li><a href="#">Ethic</a></li>
                        <li><a href="#">Goals</a></li>
                    </ul>
                </div>
                <div class="item">
                    <h4>about</h4>
                    <ul>
                        <li><a href="#">Team</a></li>
                        <li><a href="#">Join us</a></li>
                        <li><a href="#">Ethic</a></li>
                        <li><a href="#">Goals</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
    <script src="./JS/script.js"></script>
    <script src="./JS/wow.min.js"></script>
    <script>
        new WOW().init();
    </script>
</body>