
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>searchjob</title>
    <link rel="stylesheet" href="/resources/css/style.css"/>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
  </head>
  <body>
  <header>
  <div class="container">
    <img src="/resources/img/logo1.png" alt="searchjob" class="logo">
    <div class="findblock">
      <span class="icon"><i class="fa fa-search"></i></span>
      <input class="inputsearch" type="search" id="search" placeholder="Search..." />
      <select class="selectType">
      </select>
    </div>
  </div>
  </header>
  <section class="center">
    <div class="resume">
      <a href="/employee_login"><button class="button">Post a CV</button></a>
    </div>
    <div class="vacancy">
      <a href="/employer_login"><button class="button">Post a vacancy</button></a>
    </div>
  </section>


  </body>
</html>
